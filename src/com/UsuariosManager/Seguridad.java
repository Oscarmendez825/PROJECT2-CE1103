package com.UsuariosManager;

/***
 * Security class, encharged of the initial settings of the change-password process
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020`
 */
public class Seguridad {

    private String nuevaContraseña = "";
    private String contraseñaVieja = "";
    private String nombre = "";
    private String correo = "";

    /***
     * This method returns the 'nuevaContraseña' variable.
     * @return String
     */
    public String getNuevaContraseña() {
        return nuevaContraseña;
    }

    /***
     * This method changes the value of the 'nuevaContraseña' variable.
     * @param nuevaContraseña String
     */
    public void setNuevaContraseña(String nuevaContraseña) {
        this.nuevaContraseña = nuevaContraseña;
    }

    /***
     * This method returns the 'contraseñaVieja' variable.
     * @return String
     */
    public String getContraseñaVieja() {
        return contraseñaVieja;
    }

    /***
     * This method changes the value of the 'contraseñaVieja' variable.
     * @param contraseñaVieja String
     */
    public void setContraseñaVieja(String contraseñaVieja) {
        this.contraseñaVieja = contraseñaVieja;
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
     * This method returns the 'correo' variable.
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    /***
     * This method changes the value of the 'correo' variable.
     * @param correo String
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
