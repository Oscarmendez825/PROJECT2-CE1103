package com.JsonManager;

import com.EmpresasManager.Empresa;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.RandomAccessFile;
/***
 * Company creator in Json files.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class CreateJsonEmpresa {

    String direccion = "C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONEmpresas.json";
    /***
     * This method adds a new company to the respective Json file.
     * @param empresa String
     */
    public void empresaJson(Empresa empresa) throws IOException {
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


            jsonObject.put("nombre",empresa.getNombre());
            jsonObject.put("contacto",empresa.getContacto());
            jsonObject.put("horario",empresa.getHorario());


            JSONArray seguidores = new JSONArray();

            for (int i = 0; i<empresa.getSeguidores().getSize();i++){
                seguidores.add(empresa.getSeguidores().get(i));

            }

            jsonObject.put("seguidores",seguidores);




            randomAccessFile.writeBytes("[" + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre",empresa.getNombre());
            jsonObject.put("contacto",empresa.getContacto());
            jsonObject.put("horario",empresa.getHorario());


            JSONArray seguidores = new JSONArray();
            for (int i = 0; i<empresa.getSeguidores().getSize();i++){
                seguidores.add(empresa.getSeguidores().get(i));

            }

            jsonObject.put("seguidores",seguidores);
            randomAccessFile.writeBytes("," + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }

    }

}
