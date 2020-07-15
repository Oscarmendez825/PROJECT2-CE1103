package com.UsuariosManager;

import com.AVL.AVLTree;
import com.ListaEnlazada.ListaEnlazada;
import com.RecetasManager.Receta;

import java.util.LinkedList;

public class Usuario{

    private String nombre = "";
    private String password = "";
    private String email = "";
    private int edad = 0;
    ListaEnlazada<Receta> listaRecetas = new ListaEnlazada<Receta>();
    ListaEnlazada<GenericUser> seguidos = new ListaEnlazada<GenericUser>();
    ListaEnlazada<GenericUser> seguidores = new ListaEnlazada<GenericUser>();
    private boolean isChef = false;
    AVLTree recetas = new AVLTree();

    public Usuario() {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.edad = edad;



    }

    public ListaEnlazada<Receta> getListaRecetas() {

        return listaRecetas;
    }

    public ListaEnlazada<GenericUser> getSeguidos() {

        return seguidos;
    }

    public ListaEnlazada<GenericUser> getSeguidores() {

        return seguidores;
    }

    public void agregarReceta(Receta receta){
        this.listaRecetas.add(receta);

    }


    public String getNombre() {

        return nombre;
    }
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {

        this.password = password;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }

    public int getEdad() {

        return edad;
    }

    public void setEdad(int edad) {

        this.edad = edad;
    }

    public boolean getIsChef() {
        return isChef;
    }

    public void setIsChef(boolean chef) {
        isChef = chef;
    }

    public AVLTree getRecetas() {
        return recetas;
    }
}
