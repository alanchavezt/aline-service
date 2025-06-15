package model;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String nombre_usuario;
    private String correo;
    private String contrasena;
    private String ruta_logo;
    private String fecha_registro;
    private boolean estado;

    // Constructor
    public Usuario(int id, String nombre, String apellido, String nombre_usuario,
                   String correo, String contrasena, String ruta_logo,
                   String fecha_registro, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_usuario = nombre_usuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ruta_logo = ruta_logo;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRuta_logo() {
        return ruta_logo;
    }

    public void setRuta_logo(String ruta_logo) {
        this.ruta_logo = ruta_logo;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
