package com.JsonManager;

import com.UsuariosManager.Usuario;
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
            randomAccessFile.writeBytes("[" + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre",usuario.getNombre());
            jsonObject.put("password",usuario.getPassword());
            jsonObject.put("email",usuario.getEmail());
            jsonObject.put("edad",usuario.getEdad());
            randomAccessFile.writeBytes("," + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }

    }
}






