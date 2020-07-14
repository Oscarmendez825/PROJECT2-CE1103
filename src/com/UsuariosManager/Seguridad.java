package com.UsuariosManager;

public class Seguridad {

    private String nuevaContraseña = "";
    private String contraseñaVieja = "";
    private String nombre = "";
    private String correo = "";

    public String getNuevaContraseña() {
        return nuevaContraseña;
    }

    public void setNuevaContraseña(String nuevaContraseña) {
        this.nuevaContraseña = nuevaContraseña;
    }

    public String getContraseñaVieja() {
        return contraseñaVieja;
    }

    public void setContraseñaVieja(String contraseñaVieja) {
        this.contraseñaVieja = contraseñaVieja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
