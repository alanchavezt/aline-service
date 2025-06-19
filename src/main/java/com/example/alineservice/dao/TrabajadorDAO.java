package com.example.alineservice.dao;

import com.example.alineservice.model.Trabajador;
import com.example.alineservice.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO {
    public List<Trabajador> listar() {
        List<Trabajador> lista = new ArrayList<>();
        String sql = "SELECT * FROM mae_trabajador";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Trabajador t = new Trabajador();
                t.setIdTrabajador(rs.getInt("id_trabajador"));
                t.setNumeroDocumento(rs.getString("numero_documento"));
                t.setIdTipoDocumento(rs.getInt("id_tipo_documento"));
                t.setIdTipoEntidad(rs.getInt("id_tipo_entidad"));
                t.setRazonSocial(rs.getString("razon_social"));
                t.setApellidoPaterno(rs.getString("apellido_paterno"));
                t.setApellidoMaterno(rs.getString("apellido_materno"));
                t.setNombres(rs.getString("nombres"));
                t.setDireccionFiscal(rs.getString("direccion_fiscal"));
                t.setCargo(rs.getString("cargo"));
                t.setFechaIngreso(rs.getString("fecha_ingreso"));
                t.setEmail(rs.getString("email"));
                t.setTelefono(rs.getString("telefono"));
                t.setNota(rs.getString("nota"));
                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean registrar(Trabajador t) {
        String sql = "INSERT INTO mae_trabajador(numero_documento, id_tipo_documento, id_tipo_entidad, razon_social, apellido_paterno, apellido_materno, nombres, direccion_fiscal, cargo, fecha_ingreso, email, telefono, nota) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getNumeroDocumento());
            stmt.setInt(2, t.getIdTipoDocumento());
            stmt.setInt(3, t.getIdTipoEntidad());
            stmt.setString(4, t.getRazonSocial());
            stmt.setString(5, t.getApellidoPaterno());
            stmt.setString(6, t.getApellidoMaterno());
            stmt.setString(7, t.getNombres());
            stmt.setString(8, t.getDireccionFiscal());
            stmt.setString(9, t.getCargo());
            stmt.setString(10, t.getFechaIngreso());
            stmt.setString(11, t.getEmail());
            stmt.setString(12, t.getTelefono());
            stmt.setString(13, t.getNota());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM mae_trabajador WHERE id_trabajador = ?";
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

