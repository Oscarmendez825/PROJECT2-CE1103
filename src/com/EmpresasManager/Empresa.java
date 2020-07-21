package com.EmpresasManager;

import com.ListaEnlazada.ListaEnlazada;
import com.UsuariosManager.Usuario;



public class Empresa {

    private String nombre = "";
    private String contacto = "";
    private String horario = "";
    private ListaEnlazada<String> seguidores = new ListaEnlazada<String>();

    public void addSeguidor(Usuario usuario){
        seguidores.add(usuario.getNombre());
    }
    public ListaEnlazada<String> getSeguidores(){
        return seguidores;

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
