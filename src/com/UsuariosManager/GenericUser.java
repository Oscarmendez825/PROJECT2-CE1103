package com.UsuariosManager;

import org.json.simple.JSONArray;

/***
 * This class generates a generic user, omitting compromised or private information, which can be showed to the public.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class GenericUser {
    private String nombre;
    private String correo;
    JSONArray seguidos = new JSONArray();
    JSONArray seguidores = new JSONArray();

    /***
     * Constructor method ofb the 'GenericUser' class.
     */
    public GenericUser(){

    }

    /***
     * This method returns the 'nombre' variable.
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /***"
     * This method changes the value of the 'nombre' variable.
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * This method returns the 'correo' variable.
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    /***"
     * This method changes the value of the 'correo' variable.
     * @param correo String
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /***
     * This method returns the 'seguidos' variable.
     * @return JSONArray
     */
    public JSONArray getSeguidos() {
        return seguidos;
    }

    /***
     * This method returns the 'seguidores' variable.
     * @return JSONArray
     */
    public JSONArray getSeguidores() {
        return seguidores;
    }
}
