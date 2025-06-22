package com.example.alineservice.dao;

import com.example.alineservice.model.Sesion;
import com.example.alineservice.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SesionDAO {

    public List<Sesion> listar() {
        List<Sesion> lista = new ArrayList<>();
        String sql = "SELECT * FROM trs_sesion";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Sesion s = new Sesion();
                s.setIdSesion(rs.getInt("id_sesion"));
                s.setIdUsuario(rs.getInt("id_usuario"));
                s.setFechaInicio(rs.getString("fecha_inicio"));
                s.setFechaCierre(rs.getString("fecha_cierre"));
                lista.add(s);
            }
        } catch (SQLException e) {
            System.err.println("[LISTAR SESIONES ERROR] " + e.getMessage());
        }
        return lista;
    }

    // Método para registrar sesión y retornar el ID generado
    public int registrarYRetornarId(Sesion s) {
        String sql = "INSERT INTO trs_sesion (id_usuario) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, s.getIdUsuario());
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // id_sesion generado
                }
            }
        } catch (SQLException e) {
            System.err.println("[REGISTRAR SESION ERROR] " + e.getMessage());
        }
        return -1;
    }

    public boolean registrar(Sesion s) {
        String sql = "INSERT INTO trs_sesion (id_usuario, fecha_inicio, fecha_cierre) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getIdUsuario());
            stmt.setString(2, s.getFechaInicio());
            stmt.setString(3, s.getFechaCierre());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[REGISTRAR SESION (manual) ERROR] " + e.getMessage());
        }
        return false;
    }

    public boolean actualizar(Sesion s) {
        String sql = "UPDATE trs_sesion SET id_usuario = ?, fecha_inicio = ?, fecha_cierre = ? WHERE id_sesion = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getIdUsuario());
            stmt.setString(2, s.getFechaInicio());
            stmt.setString(3, s.getFechaCierre());
            stmt.setInt(4, s.getIdSesion());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[ACTUALIZAR SESION ERROR] " + e.getMessage());
        }
        return false;
    }

    public boolean eliminar(int idSesion) {
        String sql = "DELETE FROM trs_sesion WHERE id_sesion = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idSesion);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("[ELIMINAR SESION ERROR] " + e.getMessage());
        }
        return false;
    }

    public boolean cerrarSesion(int idSesion, String fechaCierre) {
        String sql = "UPDATE trs_sesion SET fecha_cierre = ? WHERE id_sesion = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fechaCierre);
            stmt.setInt(2, idSesion);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[CERRAR SESION ERROR] " + e.getMessage());
        }
        return false;
    }
}
