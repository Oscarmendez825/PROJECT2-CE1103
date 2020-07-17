package com.UsuariosManager;

import com.ListaEnlazada.ListaEnlazada;

public class MyMenu {

    private String[] referencia = new String[2];
    private String autor = "";
    private String nombre= "";
    ListaEnlazada<String[]> lista = new ListaEnlazada<String[]>();

    public MyMenu (){


    }
    public void setValores(String autor,String nombre){

        referencia[0] = autor;
        referencia[1] = nombre;
        lista.add(referencia);
    }

    public ListaEnlazada<String[]> getLista() {
        return lista;
    }
}
