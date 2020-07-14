package com.UsuariosManager;

import org.json.simple.JSONArray;

public class GenericUser {
    private String nombre;
    private String correo;
    JSONArray seguidos = new JSONArray();
    JSONArray seguidores = new JSONArray();

    public GenericUser(){


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

    public JSONArray getSeguidos() {
        return seguidos;
    }

    public JSONArray getSeguidores() {
        return seguidores;
    }
}
