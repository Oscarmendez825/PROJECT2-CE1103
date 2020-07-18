package com.JsonManager;

import com.UsuariosManager.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



import java.io.*;

public class CreateJsonUser {


    String direccion = "C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json";


    public void usuarioJson(Usuario usuario) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(direccion, "rw");
        long pos = randomAccessFile.length();
        while (randomAccessFile.length() > 0) {
            pos--;
            randomAccessFile.seek(pos);
            if (randomAccessFile.readByte() == ']') {
                randomAccessFile.seek(pos);
                break;
            }

        }
        if(randomAccessFile.length() == 0){
            JSONObject jsonObject = new JSONObject();


            jsonObject.put("nombre",usuario.getNombre());
            jsonObject.put("password",usuario.getPassword());
            jsonObject.put("email",usuario.getEmail());
            jsonObject.put("edad",usuario.getEdad());
            jsonObject.put("chef", usuario.getIsChef());
            JSONArray seguidos = new JSONArray();
            JSONArray seguidores = new JSONArray();
            JSONArray empresas = new JSONArray();
            for (int i = 0; i<usuario.getSeguidores().getSize();i++){
                seguidores.add(usuario.getSeguidores().get(i));

            }
            for (int i = 0; i<usuario.getSeguidos().getSize();i++) {
                seguidores.add(usuario.getSeguidos().get(i));

            }
            for (int i = 0; i < usuario.getEmpresa().getSize();i++){
                empresas.add(usuario.getEmpresa().get(i));

            }
            jsonObject.put("seguidores",seguidores);
            jsonObject.put("seguidos",seguidos);
            jsonObject.put("empresa",empresas);

            randomAccessFile.writeBytes("[" + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre",usuario.getNombre());
            jsonObject.put("password",usuario.getPassword());
            jsonObject.put("email",usuario.getEmail());
            jsonObject.put("edad",usuario.getEdad());
            jsonObject.put("chef", usuario.getIsChef());
            jsonObject.put("seguidos",usuario.getSeguidos());
            jsonObject.put("seguidores",usuario.getSeguidores());

            JSONArray seguidos = new JSONArray();
            JSONArray seguidores = new JSONArray();
            JSONArray empresas = new JSONArray();
            for (int i = 0; i<usuario.getSeguidores().getSize();i++){
                seguidores.add(usuario.getSeguidores().get(i));

            }
            for (int i = 0; i<usuario.getSeguidos().getSize();i++){
                seguidores.add(usuario.getSeguidos().get(i));

            }
            for (int i = 0; i < usuario.getEmpresa().getSize();i++){
                empresas.add(usuario.getEmpresa().get(i));

            }
            jsonObject.put("seguidores",seguidores);
            jsonObject.put("seguidos",seguidos);
            jsonObject.put("empresa",empresas);

            randomAccessFile.writeBytes("," + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }

    }
}






