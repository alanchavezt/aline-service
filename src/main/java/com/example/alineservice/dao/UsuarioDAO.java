package com.example.alineservice.dao;

import com.example.alineservice.model.Usuario;
import com.example.alineservice.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Usuario login(String correo, String contrasena) {
        String sql = "SELECT * FROM mae_usuario WHERE correo = ? AND contrasena_hash = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapUsuario(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error en login:");
            e.printStackTrace();
        }
        return null;
    }

    public boolean registrar(Usuario usuario) {
        String sql = "INSERT INTO mae_usuario(nombre_usuario, correo, contrasena_hash) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasenaHash());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario:");
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeCorreo(String correo) {
        String sql = "SELECT COUNT(*) FROM mae_usuario WHERE correo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.err.println("Error al verificar correo:");
            e.printStackTrace();
        }
        return false;
    }

    public boolean existeUsuario(String nombreUsuario) {
        String sql = "SELECT COUNT(*) FROM mae_usuario WHERE nombre_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.err.println("Error al verificar nombre de usuario:");
            e.printStackTrace();
        }
        return false;
    }

    public List<Usuario> getAll() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM mae_usuario";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapUsuario(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los usuarios:");
            e.printStackTrace();
        }
        return lista;
    }

    public Usuario obtenerPorId(int id) {
        String sql = "SELECT * FROM mae_usuario WHERE id_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapUsuario(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario por ID:");
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizar(int id, Usuario usuario) {
        String sql = "UPDATE mae_usuario SET nombre_usuario = ?, correo = ?, contrasena_hash = ?, estado_cuenta = ? WHERE id_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasenaHash());
            stmt.setBoolean(4, usuario.isEstadoCuenta());
            stmt.setInt(5, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario:");
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM mae_usuario WHERE id_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario:");
            e.printStackTrace();
        }
        return false;
    }

    private Usuario mapUsuario(ResultSet rs) throws SQLException {
        Usuario u = new Usuario();
        u.setIdUsuario(rs.getInt("id_usuario"));
        u.setNombreUsuario(rs.getString("nombre_usuario"));
        u.setCorreo(rs.getString("correo"));
        u.setContrasenaHash(rs.getString("contrasena_hash"));
        u.setFechaRegistro(rs.getString("fecha_registro"));
        u.setEstadoCuenta(rs.getBoolean("estado_cuenta"));
        return u;
    }
}
