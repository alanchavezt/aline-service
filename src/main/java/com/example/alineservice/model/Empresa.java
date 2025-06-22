package com.example.alineservice.model;

public class Empresa {
    private int idEmpresa;
    private int idUsuario;
    private String nombreEmpresa;
    private String direccion;
    private String ruc;
    private String rutaLogo;

    // Constructor vacío
    public Empresa() {}

    // Constructor completo (opcional si lo necesitas)
    public Empresa(int idEmpresa, int idUsuario, String nombreEmpresa, String direccion, String ruc, String rutaLogo) {
        this.idEmpresa = idEmpresa;
        this.idUsuario = idUsuario;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.ruc = ruc;
        this.rutaLogo = rutaLogo;
    }

    // Getters y Setters
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRutaLogo() {
        return rutaLogo;
    }

    public void setRutaLogo(String rutaLogo) {
        this.rutaLogo = rutaLogo;
    }
}
