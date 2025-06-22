package com.example.alineservice.dao;

import com.example.alineservice.model.Boleta;
import com.example.alineservice.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoletaDAO {
    public List<Boleta> listar() {
        List<Boleta> lista = new ArrayList<>();
        String sql = "SELECT * FROM trs_boleta";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Boleta b = new Boleta();
                b.setIdBoleta(rs.getInt("id_boleta"));
                b.setCorrelativo(rs.getInt("correlativo"));
                b.setNumeroBoleta(rs.getString("numero_boleta"));
                b.setIdTrabajador(rs.getInt("id_trabajador"));
                b.setIdTipoBoleta(rs.getInt("id_tipo_boleta"));
                b.setFechaEmision(rs.getString("fecha_emision"));
                b.setRetencionRentaAplica(rs.getBoolean("retencion_renta_aplica"));
                b.setIdMoneda(rs.getInt("id_moneda"));
                b.setTipoCambio(rs.getDouble("tipo_cambio"));
                b.setRemuneracionBasica(rs.getDouble("remuneracion_basica"));
                b.setAsignacionFamiliar(rs.getDouble("asignacion_familiar"));
                b.setRetencionRenta(rs.getDouble("retencion_renta"));
                b.setSnp(rs.getDouble("snp"));
                b.setAfp(rs.getDouble("afp"));
                b.setComisionAfp(rs.getDouble("comision_afp"));
                b.setSeguroAfp(rs.getDouble("seguro_afp"));
                b.setEssaludRegular(rs.getDouble("essalud_regular"));
                b.setBancarizado(rs.getBoolean("bancarizado"));
                b.setDescripcion(rs.getString("descripcion"));
                b.setRutaPdf(rs.getString("ruta_pdf"));
                b.setFechaCreacion(rs.getString("fecha_creacion"));
                b.setIdUsuario(rs.getInt("id_usuario"));
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean registrar(Boleta b) {
        String sql = "INSERT INTO trs_boleta(correlativo, numero_boleta, id_trabajador, id_tipo_boleta, fecha_emision, retencion_renta_aplica, id_moneda, tipo_cambio, remuneracion_basica, asignacion_familiar, retencion_renta, snp, afp, comision_afp, seguro_afp, essalud_regular, bancarizado, descripcion, ruta_pdf, fecha_creacion, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, b.getCorrelativo());
            stmt.setString(2, b.getNumeroBoleta());
            stmt.setInt(3, b.getIdTrabajador());
            stmt.setInt(4, b.getIdTipoBoleta());
            stmt.setString(5, b.getFechaEmision());
            stmt.setBoolean(6, b.isRetencionRentaAplica());
            stmt.setInt(7, b.getIdMoneda());
            stmt.setDouble(8, b.getTipoCambio());
            stmt.setDouble(9, b.getRemuneracionBasica());
            stmt.setDouble(10, b.getAsignacionFamiliar());
            stmt.setDouble(11, b.getRetencionRenta());
            stmt.setDouble(12, b.getSnp());
            stmt.setDouble(13, b.getAfp());
            stmt.setDouble(14, b.getComisionAfp());
            stmt.setDouble(15, b.getSeguroAfp());
            stmt.setDouble(16, b.getEssaludRegular());
            stmt.setBoolean(17, b.isBancarizado());
            stmt.setString(18, b.getDescripcion());
            stmt.setString(19, b.getRutaPdf());
            stmt.setString(20, b.getFechaCreacion());
            stmt.setInt(21, b.getIdUsuario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizar(Boleta b) {
        String sql = "UPDATE trs_boleta SET correlativo = ?, numero_boleta = ?, id_trabajador = ?, id_tipo_boleta = ?, fecha_emision = ?, retencion_renta_aplica = ?, id_moneda = ?, tipo_cambio = ?, remuneracion_basica = ?, asignacion_familiar = ?, retencion_renta = ?, snp = ?, afp = ?, comision_afp = ?, seguro_afp = ?, essalud_regular = ?, bancarizado = ?, descripcion = ?, ruta_pdf = ?, fecha_creacion = ?, id_usuario = ? WHERE id_boleta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, b.getCorrelativo());
            stmt.setString(2, b.getNumeroBoleta());
            stmt.setInt(3, b.getIdTrabajador());
            stmt.setInt(4, b.getIdTipoBoleta());
            stmt.setString(5, b.getFechaEmision());
            stmt.setBoolean(6, b.isRetencionRentaAplica());
            stmt.setInt(7, b.getIdMoneda());
            stmt.setDouble(8, b.getTipoCambio());
            stmt.setDouble(9, b.getRemuneracionBasica());
            stmt.setDouble(10, b.getAsignacionFamiliar());
            stmt.setDouble(11, b.getRetencionRenta());
            stmt.setDouble(12, b.getSnp());
            stmt.setDouble(13, b.getAfp());
            stmt.setDouble(14, b.getComisionAfp());
            stmt.setDouble(15, b.getSeguroAfp());
            stmt.setDouble(16, b.getEssaludRegular());
            stmt.setBoolean(17, b.isBancarizado());
            stmt.setString(18, b.getDescripcion());
            stmt.setString(19, b.getRutaPdf());
            stmt.setString(20, b.getFechaCreacion());
            stmt.setInt(21, b.getIdUsuario());
            stmt.setInt(22, b.getIdBoleta());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM trs_boleta WHERE id_boleta = ?";
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