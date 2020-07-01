package com.UsuariosManager;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;

@Path("USUARIOS")
public class RegistroUsuario {


    static ManejoUsuarios usuarios = new ManejoUsuarios();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("LISTAUSUARIOS")
    public LinkedList<Usuario> getUsuario(){
        return usuarios.getUsers();

    }

    @POST
    @Path("NUEVOUSUARIO")
    public Usuario agregarUsuario(Usuario usuario) {

        usuarios.crearUsuario(usuario);
        return usuario;
    }
}
