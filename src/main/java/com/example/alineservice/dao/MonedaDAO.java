package com.example.alineservice.dao;

import com.example.alineservice.model.Moneda;
import com.example.alineservice.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonedaDAO {
    public List<Moneda> listar() {
        List<Moneda> lista = new ArrayList<>();
        String sql = "SELECT * FROM mae_moneda";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Moneda m = new Moneda();
                m.setIdMoneda(rs.getInt("id_moneda"));
                m.setNombreMoneda(rs.getString("nombre_moneda"));
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean registrar(Moneda m) {
        String sql = "INSERT INTO mae_moneda(nombre_moneda) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNombreMoneda());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizar(Moneda m) {
        String sql = "UPDATE mae_moneda SET nombre_moneda = ? WHERE id_moneda = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNombreMoneda());
            stmt.setInt(2, m.getIdMoneda());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM mae_moneda WHERE id_moneda = ?";
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
