package com.example.alineservice.model;

public class Boleta {
    private int idBoleta;
    private int correlativo;
    private String numeroBoleta;
    private int idTrabajador;
    private int idTipoBoleta;
    private String fechaEmision;
    private boolean retencionRentaAplica;
    private int idMoneda;
    private double tipoCambio;
    private double remuneracionBasica;
    private double asignacionFamiliar;
    private double retencionRenta;
    private double snp;
    private double afp;
    private double comisionAfp;
    private double seguroAfp;
    private double essaludRegular;
    private boolean bancarizado;
    private String descripcion;
    private String rutaPdf;
    private String fechaCreacion;
    private int idUsuario;

    public int getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(int idBoleta) {
        this.idBoleta = idBoleta;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(String numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdTipoBoleta() {
        return idTipoBoleta;
    }

    public void setIdTipoBoleta(int idTipoBoleta) {
        this.idTipoBoleta = idTipoBoleta;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public boolean isRetencionRentaAplica() {
        return retencionRentaAplica;
    }

    public void setRetencionRentaAplica(boolean retencionRentaAplica) {
        this.retencionRentaAplica = retencionRentaAplica;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public double getRemuneracionBasica() {
        return remuneracionBasica;
    }

    public void setRemuneracionBasica(double remuneracionBasica) {
        this.remuneracionBasica = remuneracionBasica;
    }

    public double getAsignacionFamiliar() {
        return asignacionFamiliar;
    }

    public void setAsignacionFamiliar(double asignacionFamiliar) {
        this.asignacionFamiliar = asignacionFamiliar;
    }

    public double getRetencionRenta() {
        return retencionRenta;
    }

    public void setRetencionRenta(double retencionRenta) {
        this.retencionRenta = retencionRenta;
    }

    public double getSnp() {
        return snp;
    }

    public void setSnp(double snp) {
        this.snp = snp;
    }

    public double getAfp() {
        return afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public double getComisionAfp() {
        return comisionAfp;
    }

    public void setComisionAfp(double comisionAfp) {
        this.comisionAfp = comisionAfp;
    }

    public double getSeguroAfp() {
        return seguroAfp;
    }

    public void setSeguroAfp(double seguroAfp) {
        this.seguroAfp = seguroAfp;
    }

    public double getEssaludRegular() {
        return essaludRegular;
    }

    public void setEssaludRegular(double essaludRegular) {
        this.essaludRegular = essaludRegular;
    }

    public boolean isBancarizado() {
        return bancarizado;
    }

    public void setBancarizado(boolean bancarizado) {
        this.bancarizado = bancarizado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaPdf() {
        return rutaPdf;
    }

    public void setRutaPdf(String rutaPdf) {
        this.rutaPdf = rutaPdf;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
