package com.UsuariosManager;

import com.ListaEnlazada.ListaEnlazada;
/***
 * This class is the template for the user's MyMenu, section where the user can show to other people the
 * own recipes and other interesting recipes.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class MyMenu {

    private String[] referencia = new String[2];

    ListaEnlazada<String[]> lista = new ListaEnlazada<String[]>();
    /***
     * Constructor method ofb the 'MyMenu' class.
     */
    public MyMenu (){


    }
    /***
     * This method sets and adds a recipe's reference into the list of MyMenu.
     * @param autor String
     * @param nombre String
     */
    public void setValores(String autor,String nombre){

        referencia[0] = autor;
        referencia[1] = nombre;
        lista.add(referencia);
    }
    /***
     * This method returns the 'lista' variable.
     * @return ListaEnlazada
     */
    public ListaEnlazada<String[]> getLista() {
        return lista;
    }
    /***
     * This method sets a different list for MyMenu.
     * @param lista ListaEnlazada
     */
    public void setLista(ListaEnlazada<String[]> lista) {
        this.lista = lista;
    }
}
