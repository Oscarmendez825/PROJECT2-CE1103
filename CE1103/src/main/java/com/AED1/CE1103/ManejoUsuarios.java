package com.AED1.CE1103;


import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;



public class ManejoUsuarios {
	
	 LinkedList<Usuario> usuarios;
	
	public ManejoUsuarios() {
		usuarios = new LinkedList<Usuario>();

	}


	
	public Usuario getUsuario(String name) {

		for (Usuario i : usuarios) {
			
			if (i.getNombre().equals(name)) {
				
				return i;
			}
		}
		
		return null;
		
	}

	public LinkedList<Usuario> getUsers() {
		// TODO Auto-generated method stub
		for (Usuario i : usuarios) {
			System.out.println(i);
			
		}
		return usuarios;
	}
	
	public void crearUsuario(Usuario nuevo) {
		Usuario usuario = new Usuario();
		usuario.setNombre(nuevo.getNombre());
		usuario.setEmail(nuevo.getEmail());
		try {
			usuario.setPassword(MD5.encriptar(nuevo.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		this.usuarios.add(usuario);
		
		

		
	}
	
}
