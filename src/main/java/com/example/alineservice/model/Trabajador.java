package com.example.alineservice.model;

public class Trabajador {
    private int idTrabajador;
    private String numeroDocumento;
    private int idTipoDocumento;
    private int idTipoEntidad;
    private String razonSocial;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String direccionFiscal;
    private String cargo;
    private String fechaIngreso;
    private String email;
    private String telefono;
    private String nota;

    // Getters y Setters
    public int getIdTrabajador() { return idTrabajador; }
    public void setIdTrabajador(int idTrabajador) { this.idTrabajador = idTrabajador; }

    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }

    public int getIdTipoDocumento() { return idTipoDocumento; }
    public void setIdTipoDocumento(int idTipoDocumento) { this.idTipoDocumento = idTipoDocumento; }

    public int getIdTipoEntidad() { return idTipoEntidad; }
    public void setIdTipoEntidad(int idTipoEntidad) { this.idTipoEntidad = idTipoEntidad; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getDireccionFiscal() { return direccionFiscal; }
    public void setDireccionFiscal(String direccionFiscal) { this.direccionFiscal = direccionFiscal; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getNota() { return nota; }
    public void setNota(String nota) { this.nota = nota; }
}
