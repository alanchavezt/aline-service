package com.example.alineservice.dao;

import com.example.alineservice.model.TipoBoleta;
import com.example.alineservice.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoBoletaDAO {

    public List<TipoBoleta> listar() {
        List<TipoBoleta> lista = new ArrayList<>();
        String sql = "SELECT * FROM mae_tipo_boleta";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TipoBoleta t = new TipoBoleta();
                t.setIdTipoBoleta(rs.getInt("id_tipo_boleta"));
                t.setNombreTipoBoleta(rs.getString("nombre_tipo_boleta"));
                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean registrar(TipoBoleta tipo) {
        String sql = "INSERT INTO mae_tipo_boleta(nombre_tipo_boleta) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipo.getNombreTipoBoleta());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizar(TipoBoleta tipo) {
        String sql = "UPDATE mae_tipo_boleta SET nombre_tipo_boleta = ? WHERE id_tipo_boleta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipo.getNombreTipoBoleta());
            stmt.setInt(2, tipo.getIdTipoBoleta());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM mae_tipo_boleta WHERE id_tipo_boleta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
