package com.UsuariosManager;




import com.EmpresasManager.Empresa;
import com.JsonManager.CambiarValorJson;
import com.JsonManager.CreateJsonReceta;
import com.JsonManager.ReadJsonFile;
import com.ListaEnlazada.ListaEnlazada;
import com.RecetasManager.Receta;
import org.json.simple.JSONArray;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@Path("USUARIOS")
public class RegistroUsuario {


    public static ManejoUsuarios usuarios = new ManejoUsuarios();



    public static String usuarioExst(boolean valor) {
        if (valor == true) {
            return "ERROR";

        }else {
            return "AGREGADO";

        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUsuario/{nombre}")
    public GenericUser getUsuario(@PathParam("nombre") String nombre){
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
    @GET
    @Path("newsFeed/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONArray getNewsFeed(@PathParam("nombre") String nombre){
        return usuarios.getNewsFeed(nombre);

    }

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
    @POST
    @Path("IniciarSesion")
    @Produces(MediaType.TEXT_PLAIN)
    public String iniciarSesion(Usuario usuario){

        return usuarios.verificacion(usuario);
    }

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
    @GET
    @Path("imprimir")
    @Produces(MediaType.TEXT_PLAIN)
    public String imprimir(){
        ReadJsonFile.leerJson();

        return "jiji";

    }



    @POST
    @Path("newEmpresa/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String crearEmpresa(Empresa empresa,@PathParam("name") String name){
        return usuarios.agregarEmpresa(empresa,name);

    }
    @POST
    @Path("cargarDatos")
    public void cargarDatos(){
        usuarios.cargarUsuarios();
        usuarios.cargarRecetas();
        usuarios.cargarEmpresas();
    }

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
}
