package com.AED1.CE1103;

import java.util.LinkedList;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


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
