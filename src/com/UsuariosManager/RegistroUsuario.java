package com.UsuariosManager;


import com.ABB.BinTree;
import com.JsonManager.CreateJsonUser;
import com.ListaEnlazada.ListaEnlazada;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

@Path("USUARIOS")
public class RegistroUsuario {


    static ManejoUsuarios usuarios = new ManejoUsuarios();

/*    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUsuario/{nombre}")
    public Usuario getUsuario(@PathParam("nombre") String nombre){
        return usuarios.getUser(nombre);

    }*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("LISTAUSUARIOS")
    public LinkedList<Usuario> getUsuario(){
        return usuarios.getUsers();

    }

    @POST
    @Path("NUEVOUSUARIO")
    public Usuario agregarUsuario(Usuario usuario) {


        try {
            usuarios.crearUsuario(usuario);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
