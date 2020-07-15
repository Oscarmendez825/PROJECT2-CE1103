package com.UsuariosManager;




import com.JsonManager.CambiarValorJson;
import com.JsonManager.CreateJsonReceta;
import com.JsonManager.ReadJsonFile;
import com.ListaEnlazada.ListaEnlazada;
import com.RecetasManager.Receta;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@Path("USUARIOS")
public class RegistroUsuario {


    static ManejoUsuarios usuarios = new ManejoUsuarios();



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
        for( int i = 0; i < usuarios.getUser(nombre).getSeguidos().getSize(); i++){
            temp.seguidos.add(usuarios.getUser(nombre).getSeguidos().get(i));
        }
        for( int i = 0; i < usuarios.getUser(nombre).getSeguidores().getSize(); i++){
            temp.seguidores.add(usuarios.getUser(nombre).getSeguidores().get(i));
        }
        return temp;

    }


    @POST
    @Path("agregarReceta")
    @Produces(MediaType.TEXT_PLAIN)
    public String agregarReceta(Receta receta){

        return usuarios.agregarReceta(receta);

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

        //AGREGAR SEGUIDOR
        GenericUser temp2 = new GenericUser();
        GenericUser temp = new GenericUser();
        //TEMP1
        temp.setNombre(usuarios.getUser(nombre).getNombre());
        temp.setCorreo(usuarios.getUser(nombre).getEmail());
        for( int i = 0; i < usuarios.getUser(nombre).getSeguidos().getSize(); i++){
            temp.seguidos.add(usuarios.getUser(nombre).getSeguidos().get(i));
        }
        for( int i = 0; i < usuarios.getUser(nombre).getSeguidores().getSize(); i++){
            temp.seguidores.add(usuarios.getUser(nombre).getSeguidores().get(i));
        }
        //TEMP2
        temp2.setNombre(usuarios.getUser(usuario.getNombre()).getNombre());
        temp2.setCorreo(usuarios.getUser(usuario.getNombre()).getEmail());
        for( int i = 0; i < usuarios.getUser(usuario.getNombre()).getSeguidos().getSize(); i++){
            temp2.seguidos.add(usuarios.getUser(nombre).getSeguidos().get(i));
        }
        for( int i = 0; i < usuarios.getUser(nombre).getSeguidores().getSize(); i++){
            temp2.seguidores.add(usuarios.getUser(nombre).getSeguidores().get(i));
        }

        usuarios.getUser(nombre).getSeguidores().add(temp2);
        usuarios.getUser(usuario.getNombre()).getSeguidos().add(temp);



        return "Seguido";
    }
    @POST
    @Path("CambioContraseña")
    @Produces(MediaType.TEXT_PLAIN)
    public String cambioContraseña(Seguridad seguridad){
        if (seguridad.getCorreo().equals(usuarios.getUser(seguridad.getNombre()).getEmail())){
            if(MD5.encriptar(seguridad.getContraseñaVieja()).equals(usuarios.getUser(seguridad.getNombre()).getPassword())){
                usuarios.getUser(seguridad.getNombre()).setPassword(MD5.encriptar(seguridad.getNuevaContraseña()));
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
        CambiarValorJson.cambiarPassword("Saul","1234");
        return "jiji";

    }

}
