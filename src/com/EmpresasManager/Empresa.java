package com.EmpresasManager;

import com.UsuariosManager.Usuario;

import java.util.LinkedList;

public class Empresa {

    private String nombre;
    private String contacto;
    private String horario;
    private LinkedList<Usuario> listaSeguidores;

    public void addSeguidor(Usuario usuario){
        listaSeguidores.add(usuario);
    }
    public LinkedList<Usuario> getListaSeguidores(){
        return listaSeguidores;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
