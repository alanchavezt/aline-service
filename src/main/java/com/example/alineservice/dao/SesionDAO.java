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
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sesion s = new Sesion();
                s.setIdSesion(rs.getInt("id_sesion"));
                s.setIdUsuario(rs.getInt("id_usuario"));
                s.setFechaInicio(rs.getString("fecha_inicio"));
                s.setFechaCierre(rs.getString("fecha_cierre"));
                lista.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean registrar(Sesion s) {
        String sql = "INSERT INTO trs_sesion(id_usuario) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, s.getIdUsuario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean cerrarSesion(int idSesion) {
        String sql = "UPDATE trs_sesion SET fecha_cierre = CURRENT_TIMESTAMP WHERE id_sesion = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSesion);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

