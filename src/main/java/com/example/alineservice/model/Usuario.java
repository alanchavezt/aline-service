package com.example.alineservice.model;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String correo;
    private String contrasenaHash;
    private String fechaRegistro;
    private boolean estadoCuenta;

    // Getters y Setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasenaHash() { return contrasenaHash; }
    public void setContrasenaHash(String contrasenaHash) { this.contrasenaHash = contrasenaHash; }

    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(String fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public boolean isEstadoCuenta() { return estadoCuenta; }
    public void setEstadoCuenta(boolean estadoCuenta) { this.estadoCuenta = estadoCuenta; }
}