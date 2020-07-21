package com.EmpresasManager;

import com.ListaEnlazada.ListaEnlazada;
import com.UsuariosManager.Usuario;

/***
 * Node class for the linked list.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Empresa {

    private String nombre = "";
    private String contacto = "";
    private String horario = "";
    private ListaEnlazada<String> seguidores = new ListaEnlazada<String>();

    /***
     * This method adds a new follower to the company.
     * @param usuario Usuario
     */
    public void addSeguidor(Usuario usuario){
        seguidores.add(usuario.getNombre());
    }

    /***
     * This method obtains the list of actual followers of the company.
     * @return ListaEnlazada
     */
    public ListaEnlazada<String> getSeguidores(){
        return seguidores;

    }

    /***
     * This method returns the 'nombre' variable.
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * This method change the content of the 'nombre' variable.
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * This method returns the 'contacto' variable.
     * @return String
     */
    public String getContacto() {
        return contacto;
    }

    /***
     * This method change the content of the 'contacto' variable.
     * @param contacto String
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /***
     * This method returns the 'horario' variable.
     * @return String
     */
    public String getHorario() {
        return horario;
    }

    /***
     * This method change the content of the 'horario' variable.
     * @param horario String
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }
}
