package com.UsuariosManager;

import com.ABB.BinTree;
import com.JsonManager.CreateJsonUser;
import com.ListaEnlazada.ListaEnlazada;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class ManejoUsuarios {

    LinkedList<Usuario> usuarios;
    CreateJsonUser jsonUser = new CreateJsonUser();
    public ManejoUsuarios() {
        usuarios = new LinkedList<Usuario>();

    }

    public LinkedList<Usuario> getUsers() {
        // TODO Auto-generated method stub
        for (Usuario i : usuarios) {
            System.out.println(i);

        }
        return usuarios;
    }
    public void crearUsuario(Usuario nuevo) throws NoSuchAlgorithmException{
        Usuario usuario = new Usuario();
        usuario.setNombre(nuevo.getNombre());
        usuario.setEmail(nuevo.getEmail());
        usuario.setEdad(nuevo.getEdad());
        usuario.setPassword(MD5.encriptar(nuevo.getPassword()));


        try {

            jsonUser.usuarioJson(usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.usuarios.add(usuario);





    }
}
