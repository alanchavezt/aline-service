package com.example.alineservice.dao;

import com.example.alineservice.model.TipoEntidad;
import com.example.alineservice.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoEntidadDAO {
    public List<TipoEntidad> listar() {
        List<TipoEntidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM mae_tipo_entidad";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TipoEntidad te = new TipoEntidad();
                te.setIdTipoEntidad(rs.getInt("id_tipo_entidad"));
                te.setNombreEntidad(rs.getString("nombre_entidad"));
                lista.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean registrar(TipoEntidad te) {
        String sql = "INSERT INTO mae_tipo_entidad(nombre_entidad) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, te.getNombreEntidad());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizar(TipoEntidad te) {
        String sql = "UPDATE mae_tipo_entidad SET nombre_entidad = ? WHERE id_tipo_entidad = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, te.getNombreEntidad());
            stmt.setInt(2, te.getIdTipoEntidad());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM mae_tipo_entidad WHERE id_tipo_entidad = ?";
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
