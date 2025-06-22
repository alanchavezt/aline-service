package com.example.alineservice.dao;

import com.example.alineservice.model.Empresa;
import com.example.alineservice.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    public List<Empresa> listar() {
        List<Empresa> lista = new ArrayList<>();
        String sql = "SELECT * FROM mae_empresa";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Empresa e = new Empresa();
                e.setIdEmpresa(rs.getInt("id_empresa"));
                e.setIdUsuario(rs.getInt("id_usuario"));
                e.setNombreEmpresa(rs.getString("nombre_empresa"));
                e.setDireccion(rs.getString("direccion"));
                e.setRuc(rs.getString("ruc"));
                e.setRutaLogo(rs.getString("ruta_logo"));
                lista.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // O usar logger
        }
        return lista;
    }

    public Empresa obtenerPorId(int idEmpresa) {
        String sql = "SELECT * FROM mae_empresa WHERE id_empresa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEmpresa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Empresa e = new Empresa();
                e.setIdEmpresa(rs.getInt("id_empresa"));
                e.setIdUsuario(rs.getInt("id_usuario"));
                e.setNombreEmpresa(rs.getString("nombre_empresa"));
                e.setDireccion(rs.getString("direccion"));
                e.setRuc(rs.getString("ruc"));
                e.setRutaLogo(rs.getString("ruta_logo"));
                return e;
            }

        } catch (SQLException e) {
            e.printStackTrace(); // O usar logger
        }
        return null;
    }

    public boolean registrar(Empresa empresa) {
        String sql = "INSERT INTO mae_empresa(id_usuario, nombre_empresa, direccion, ruc, ruta_logo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empresa.getIdUsuario());
            stmt.setString(2, empresa.getNombreEmpresa());
            stmt.setString(3, empresa.getDireccion());
            stmt.setString(4, empresa.getRuc());
            stmt.setString(5, empresa.getRutaLogo());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // O usar logger
        }
        return false;
    }

    public boolean actualizar(Empresa empresa) {
        String sql = "UPDATE mae_empresa SET nombre_empresa = ?, direccion = ?, ruc = ?, ruta_logo = ? WHERE id_empresa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, empresa.getNombreEmpresa());
            stmt.setString(2, empresa.getDireccion());
            stmt.setString(3, empresa.getRuc());
            stmt.setString(4, empresa.getRutaLogo());
            stmt.setInt(5, empresa.getIdEmpresa());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // O usar logger
        }
        return false;
    }

    public boolean eliminar(int idEmpresa) {
        String sql = "DELETE FROM mae_empresa WHERE id_empresa = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEmpresa);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace(); // O usar logger
        }
        return false;
    }
}
