package com.UsuariosManager;

import com.AVL.AVLTree;
import com.ListaEnlazada.ListaEnlazada;


public class Usuario{

    private String nombre = "";
    private String password = "";
    private String email = "";
    private int edad = 0;
    MyMenu myMenu = new MyMenu();
    NewsFeed newsFeed = new NewsFeed();
    ListaEnlazada<String> seguidos = new ListaEnlazada<String>();
    ListaEnlazada<String> seguidores = new ListaEnlazada<String>();
    ListaEnlazada<String> empresa = new ListaEnlazada<String>();
    private boolean isChef = false;
    AVLTree recetas = new AVLTree();

    public Usuario() {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.edad = edad;

    }

    public MyMenu getMyMenu() {
        return myMenu;
    }

    public ListaEnlazada<String> getSeguidos() {

        return seguidos;
    }

    public ListaEnlazada<String> getSeguidores() {

        return seguidores;
    }

    public ListaEnlazada<String> getEmpresa() {
        return empresa;
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

    public NewsFeed getNewsFeed() {
        return newsFeed;
    }

}
