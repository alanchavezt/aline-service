package com.example.alineservice.dao;

import com.example.alineservice.model.Usuario;
import com.example.alineservice.util.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Usuario login(String correo, String contrasena) {
        String sql = "SELECT * FROM mae_usuario WHERE correo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                // Correo no registrado
                Usuario noExiste = new Usuario();
                noExiste.setIdUsuario(0); // 0 = correo no registrado
                return noExiste;
            }

            String hash = rs.getString("contrasena_hash");

            if (!BCrypt.checkpw(contrasena, hash)) {
                // Contraseña incorrecta
                Usuario incorrecto = new Usuario();
                incorrecto.setIdUsuario(-1); // -1 = contraseña incorrecta
                return incorrecto;
            }

            // Usuario válido
            Usuario u = new Usuario();
            u.setIdUsuario(rs.getInt("id_usuario"));
            u.setNombreUsuario(rs.getString("nombre_usuario"));
            u.setCorreo(rs.getString("correo"));
            u.setContrasenaHash(hash);
            u.setFechaRegistro(rs.getString("fecha_registro"));
            u.setEstadoCuenta(rs.getBoolean("estado_cuenta"));
            return u;

        } catch (SQLException e) {
            System.err.println("[LOGIN ERROR] " + e.getMessage());
        }

        return null;
    }

    public boolean registrar(Usuario usuario) {
        if (usuario.getContrasenaHash().length() < 6) {
            System.err.println("[VALIDACION] La contraseña debe tener al menos 6 caracteres.");
            return false;
        }

        String hash = BCrypt.hashpw(usuario.getContrasenaHash(), BCrypt.gensalt());
        String sql = "INSERT INTO mae_usuario(nombre_usuario, correo, contrasena_hash) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, hash);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("[REGISTRO ERROR] " + e.getMessage());
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
            System.err.println("[EXISTE CORREO ERROR] " + e.getMessage());
        }

        return false;
    }

    public boolean existeUsuario(String nombre) {
        String sql = "SELECT COUNT(*) FROM mae_usuario WHERE nombre_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("[EXISTE USUARIO ERROR] " + e.getMessage());
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
