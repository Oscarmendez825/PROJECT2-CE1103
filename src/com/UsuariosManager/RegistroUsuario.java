package com.UsuariosManager;

import com.EmpresasManager.Empresa;
import com.JsonManager.CambiarValorJson;
import com.RecetasManager.Receta;


import com.sample2.RUNMAIN2;
import org.json.simple.JSONArray;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/***
 * This class manages the sign-in and sign-up process, as well as some modifications, like
 * change the password and follow other users.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
@Path("USUARIOS")
public class RegistroUsuario{


    public static ManejoUsuarios usuarios = new ManejoUsuarios();


    /***
     * This method verifies if the user exists in the BST.
     * @param valor Boolean
     * @return String
     */
    public static String usuarioExst(boolean valor) {
        if (valor == true) {
            return "ERROR";

        }else {
            return "AGREGADO";

        }
    }

    /***
     * This method creates a generic user to be showed.
     * @param nombre String
     * @return GenericUser
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUsuario/{nombre}")
    public GenericUser getUsuario(@PathParam("nombre") String nombre){
        System.out.println(usuarios.getUsuarios().isEmpty());
        GenericUser temp = new GenericUser();
        temp.setNombre(usuarios.getUser(nombre).getNombre());
        temp.setCorreo(usuarios.getUser(nombre).getEmail());
        for (int i = 0; i < usuarios.getUser(nombre).getSeguidos().getSize(); i++ ){
            temp.getSeguidos().add(usuarios.getUser(nombre).getSeguidos().get(i));

        }
        for (int i = 0; i < usuarios.getUser(nombre).getSeguidores().getSize(); i++ ){
            temp.getSeguidores().add(usuarios.getUser(nombre).getSeguidores().get(i));

        }
        return temp;
    }

    /***
     * This method obtains the NewsFeed of an user in a certain location in the server.
     * @param nombre String
     * @return JSONArray
     */
    @GET
    @Path("newsFeed/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONArray getNewsFeed(@PathParam("nombre") String nombre){
        return usuarios.getNewsFeed(nombre);

    }

    /***
     * This method adds a new recipe to the user's AVL tree.
     * @param receta Receta
     * @return String
     */
    @POST
    @Path("agregarReceta")
    @Produces(MediaType.TEXT_PLAIN)
    public String agregarReceta(Receta receta){

        try {
            return usuarios.agregarReceta(receta);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /***
     * Add an user to the BST tree.
     * @param usuario Usuario
     * @return String
     */
    @POST
    @Path("NUEVOUSUARIO")
    @Produces(MediaType.TEXT_PLAIN)
    public String agregarUsuario(Usuario usuario) {


        try {
            return usuarios.crearUsuario(usuario);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }

    /***
     * This method starts the verification and sign-up process of a new user.
     * @param usuario Usuario
     * @return String
     */
    @POST
    @Path("IniciarSesion")
    @Produces(MediaType.TEXT_PLAIN)
    public String iniciarSesion(Usuario usuario){

        return usuarios.verificacion(usuario);
    }

    /***
     * This method adds a given user as a follower of another user.
     * @param usuario Usuario
     * @param nombre String
     * @return String
     */
    @POST
    @Path("seguir/{nombre}")
    @Produces(MediaType.TEXT_PLAIN)
    public String seguir(Usuario usuario,@PathParam("nombre") String nombre ){

        if (usuarios.getUsuarios().contains(nombre) == true&&usuarios.getUsuarios().contains(usuario.getNombre()) == true){
            if(usuarios.getUsuarios().getbyName(nombre).getSeguidores().search(usuario.getNombre())==true){
                return "ERROR";

            }else{
                usuarios.getUsuarios().getbyName(nombre).getSeguidores().add(usuario.getNombre());
                usuarios.getUsuarios().getbyName(usuario.getNombre()).getSeguidos().add(nombre);
                CambiarValorJson.agregarSeguidor(nombre,usuario.getNombre());
                return "Seguido";
            }

        }else{
            return "ERROR";
        }

    }

    /***
     * This method does a requested change of password for a given user.
     * @param seguridad Seguridad
     * @return String
     */
    @POST
    @Path("CambioContraseña")
    @Produces(MediaType.TEXT_PLAIN)
    public String cambioContraseña(Seguridad seguridad){
        if (seguridad.getCorreo().equals(usuarios.getUser(seguridad.getNombre()).getEmail())){
            if(MD5.encriptar(seguridad.getContraseñaVieja()).equals(usuarios.getUser(seguridad.getNombre()).getPassword())){
                usuarios.getUser(seguridad.getNombre()).setPassword(MD5.encriptar(seguridad.getNuevaContraseña()));
                CambiarValorJson.cambiarPassword(seguridad.getNombre(),MD5.encriptar(seguridad.getNuevaContraseña()));
                return "Cambiada";
            }else{
                return "Incorrecto";

            }

        }else{
            return "Incorrecto";

        }



    }

    /***
     * This method sets the 'chef' status to a certain user.
     * @param usuario String
     */
    public void setChef(String usuario){

        usuarios.getUsuarios().getbyName(usuario).setIsChef(true);
    }


    /***
     *This method creates a new company and adds it to the Splay tree and the Json file.
     * @param empresa Empresa
     * @param name String
     * @return String
     */
    @POST
    @Path("newEmpresa/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String crearEmpresa(Empresa empresa,@PathParam("name") String name){
        return usuarios.agregarEmpresa(empresa,name);

    }

    /***
     * This method updates all the stored data in the Json files.
     */
    public void cargarDatos(){
        usuarios.cargarUsuarios();
        usuarios.cargarRecetas();
        usuarios.cargarEmpresas();
    }

    /***
     * This method adds a gven user as a follower of a certain company.
     * @param usuario Usuario
     * @param nombreEmpresa String
     * @return String
     */
    @POST
    @Path("seguirEmpresa/{nombreEmpresa}")
    @Produces(MediaType.TEXT_PLAIN)
    public String seguirEmpresa(Usuario usuario,@PathParam("nombreEmpresa") String nombreEmpresa ){

        if (usuarios.getEmpresas().contains(nombreEmpresa) == true&&usuarios.getUsuarios().contains(usuario.getNombre()) == true){
            if(usuarios.getEmpresas().find(nombreEmpresa).getSeguidores().search(usuario.getNombre())==true){
                return "ERROR";

            }else{
                usuarios.getEmpresas().find(nombreEmpresa).getSeguidores().add(usuario.getNombre());
                usuarios.getUsuarios().getbyName(usuario.getNombre()).getSeguidos().add(nombreEmpresa);
                CambiarValorJson.agregarSeguidor(nombreEmpresa,usuario.getNombre());
                CambiarValorJson.seguidorEmpresa(usuario.getNombre(),nombreEmpresa);
                return "Seguido";
            }

        }else{
            return "ERROR";
        }

    }

    /***
     * This method opens the user management interface.
     * @return String
     */
    @GET
    @Path("serverManager")
    @Produces(MediaType.TEXT_PLAIN)
    public String openI(){
        RUNMAIN2 runmain2 = new RUNMAIN2();
        runmain2.iniciar();
        return "Abriendo interfaz de usuario . . .";
    }

    /***
     * This method obtains a JSON array with all of the showed elements in the personal MyMenu of a certain user.
     * @param name String
     * @return JSONArray
     */
    @GET
    @Path("myMenu/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONArray getMyMenu(@PathParam("name") String name){
        return usuarios.getMyMenu(name);

    }


}
