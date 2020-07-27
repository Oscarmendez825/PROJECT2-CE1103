package com.UsuariosManager;

import com.AVL.AVLTree;
import com.ListaEnlazada.ListaEnlazada;

/***
 * Users class; this class is the template for the creation of 'Usuario' objects.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
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
    private int OState = 0;

    /***
     * Constructor method of the 'Usuario' class.
     */
    public Usuario() {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.edad = edad;

    }
    /***
     * This method returns the 'Ostate' variable.
     * @return Integer
     */
    public int getOState() {
        return OState;
    }
    /***
     * This method changes the value of the 'Ostate' variable.
     * @param OState Integer
     */
    public void setOState(int OState) {
        this.OState = OState;
    }
    /***
     * This method returns the 'myMenu' variable.
     * @return MyMenu
     */
    public MyMenu getMyMenu() {
        return myMenu;
    }
    /***
     * This method returns the 'seguidos' variable.
     * @return ListaEnlazada
     */
    public ListaEnlazada<String> getSeguidos() {

        return seguidos;
    }
    /***
     * This method returns the 'seguidores' variable.
     * @return ListaEnlazada
     */
    public ListaEnlazada<String> getSeguidores() {

        return seguidores;
    }
    /***
     * This method returns the 'empresa' variable.
     * @return ListaEnlazada
     */
    public ListaEnlazada<String> getEmpresa() {
        return empresa;
    }
    /***
     * This method returns the 'nombre' variable.
     * @return String
     */
    public String getNombre() {

        return nombre;
    }
    /***
     * This method changes the value of the 'nombre' variable.
     * @param nombre String
     */
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
    /***
     * This method returns the 'password' variable.
     * @return String
     */
    public String getPassword() {

        return password;
    }
    /***"
     * This method changes the value of the 'password' variable.
     * @param password String
     */
    public void setPassword(String password) {

        this.password = password;
    }
    /***
     * This method returns the 'email' variable.
     * @return String
     */
    public String getEmail() {

        return email;
    }
    /***
     * This method changes the value of the 'email' variable.
     * @param email String
     */
    public void setEmail(String email) {

        this.email = email;
    }
    /***
     * This method returns the 'edad' variable.
     * @return Integer
     */
    public int getEdad() {

        return edad;
    }
    /***
     * This method changes the value of the 'edad' variable.
     * @param edad Integer
     */
    public void setEdad(int edad) {

        this.edad = edad;
    }
    /***
     * This method returns the 'isChef' variable.
     * @return Boolean
     */
    public boolean getIsChef() {
        return isChef;
    }
    /***"
     * This method changes the value of the 'isChef' variable.
     * @param chef Boolean
     */
    public void setIsChef(boolean chef) {
        isChef = chef;
    }
    /***
     * This method returns the 'recetas' variable.
     * @return AVLTree
     */
    public AVLTree getRecetas() {
        return recetas;
    }
    /***
     * This method returns the 'newsFeed' variable.
     * @return NewsFeed
     */
    public NewsFeed getNewsFeed() {
        return newsFeed;
    }

}
