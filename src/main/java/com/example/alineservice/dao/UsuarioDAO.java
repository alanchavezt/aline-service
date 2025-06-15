package dao;

import model.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    private final String url = "jdbc:postgresql://localhost:5432/tu_base";
    private final String user = "tu_usuario";
    private final String password = "tu_contrasena";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setNombre_usuario(rs.getString("nombre_usuario"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                u.setRuta_logo(rs.getString("ruta_logo"));
                u.setFecha_registro(rs.getString("fecha_registro"));
                u.setEstado(rs.getBoolean("estado"));
                lista.add(u);
            }
        }
        return lista;
    }

    public Usuario obtenerUsuario(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellido(rs.getString("apellido"));
                    u.setNombre_usuario(rs.getString("nombre_usuario"));
                    u.setCorreo(rs.getString("correo"));
                    u.setContrasena(rs.getString("contrasena"));
                    u.setRuta_logo(rs.getString("ruta_logo"));
                    u.setFecha_registro(rs.getString("fecha_registro"));
                    u.setEstado(rs.getBoolean("estado"));
                    return u;
                }
            }
        }
        return null;
    }

    public boolean insertarUsuario(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, apellido, nombre_usuario, correo, contrasena, ruta_logo, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getNombre_usuario());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getContrasena());
            ps.setString(6, u.getRuta_logo());
            ps.setBoolean(7, u.isEstado());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean actualizarUsuario(Usuario u) throws SQLException {
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, nombre_usuario=?, correo=?, contrasena=?, ruta_logo=?, estado=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getNombre_usuario());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getContrasena());
            ps.setString(6, u.getRuta_logo());
            ps.setBoolean(7, u.isEstado());
            ps.setInt(8, u.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
