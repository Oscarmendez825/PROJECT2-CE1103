package com.UsuariosManager;
import com.BST.BinaryTree;
import com.JsonManager.CreateJsonReceta;
import com.JsonManager.CreateJsonUser;
import com.RecetasManager.Receta;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class ManejoUsuarios {

    BinaryTree usuarios;
    CreateJsonUser jsonUser = new CreateJsonUser();
    public ManejoUsuarios() {
        usuarios = new BinaryTree();

    }

    public String verificacion(Usuario usuario) {
        if (usuarios.contains(usuario)==true){
            Usuario temp = usuarios.getbyEmail(usuario.getEmail());
            usuario.setPassword(MD5.encriptar(usuario.getPassword()));
            if (temp.getPassword().equals(usuario.getPassword())){
                return "InicioCorrecto";

            }else{
                return "ContraseñaIncorrecta";

            }
        }else{
            return "UsuarioNoRegistrado";
        }
    }


    public String crearUsuario(Usuario nuevo) throws NoSuchAlgorithmException{
        if (usuarios.contains(nuevo)==true){

            return RegistroUsuario.usuarioExst(true);

        }else {
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

            this.usuarios.insert(usuario);
            return RegistroUsuario.usuarioExst(false);
        }


    }
    public Usuario getUser(String nombre){
        return usuarios.getbyName(nombre);

    }

    public BinaryTree getUsuarios() {
        return usuarios;
    }

    public String agregarReceta(Receta receta) throws IOException {
        if (usuarios.getbyName(receta.getAutor()).getRecetas().contains(receta.getName())==true){
            return "ERROR";

        }else{
            CreateJsonReceta r = new CreateJsonReceta();
            r.recetaJson(receta);
            usuarios.getbyName(receta.getAutor()).getRecetas().insert(receta);
            return "Agregada";
        }

    }
}
