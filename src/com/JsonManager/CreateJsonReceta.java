package com.JsonManager;

import com.RecetasManager.Receta;
import com.UsuariosManager.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.RandomAccessFile;
/***
 * Recipe creator in Json files.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class CreateJsonReceta {

    String direccion = "C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\Recetas.json";

    /***
     * This method adds a new recipe to the respective Json file.
     * @param receta String
     */
    public void recetaJson(Receta receta) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(direccion, "rw");
        long pos = randomAccessFile.length();
        JSONArray ingredientes = new JSONArray();
        JSONArray dieta = new JSONArray();
        JSONArray pasos = new JSONArray();
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


            for(int i=0; i < receta.getIngredientes().length;i++){
                ingredientes.add(receta.getIngredientes()[i]);


            }
            for(int i=0; i < receta.getDieta().length;i++){
                dieta.add(receta.getDieta()[i]);


            }
            for(int i=0; i < receta.getPasos().length;i++){
                pasos.add(receta.getPasos()[i]);


            }

            jsonObject.put("name",receta.getName());
            jsonObject.put("autor",receta.getAutor());
            jsonObject.put("tipoPlato",receta.getTipoPlato());
            jsonObject.put("porciones",receta.getPorciones());
            jsonObject.put("duracion", receta.getDuracion());
            jsonObject.put("tiempo", receta.getTiempo());
            jsonObject.put("dificultad", receta.getDificultad());
            jsonObject.put("dieta",dieta);
            jsonObject.put("ingredientes",ingredientes);
            jsonObject.put("pasos",pasos);
            jsonObject.put("calificacion",receta.getCalificacion());
            jsonObject.put("mes",receta.getMes());
            jsonObject.put("dia",receta.getDia());

            randomAccessFile.writeBytes("[" + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }else{
            JSONObject jsonObject = new JSONObject();
            for(int i=0; i < receta.getIngredientes().length;i++){
                ingredientes.add(receta.getIngredientes()[i]);


            }
            for(int i=0; i < receta.getDieta().length;i++){
                dieta.add(receta.getDieta()[i]);


            }
            for(int i=0; i < receta.getPasos().length;i++){
                pasos.add(receta.getPasos()[i]);


            }

            jsonObject.put("name",receta.getName());
            jsonObject.put("autor",receta.getAutor());
            jsonObject.put("tipoPlato",receta.getTipoPlato());
            jsonObject.put("porciones",receta.getPorciones());
            jsonObject.put("duracion", receta.getDuracion());
            jsonObject.put("tiempo", receta.getTiempo());
            jsonObject.put("dificultad", receta.getDificultad());
            jsonObject.put("dieta",dieta);
            jsonObject.put("ingredientes",ingredientes);
            jsonObject.put("pasos",pasos);
            jsonObject.put("calificacion",receta.getCalificacion());
            jsonObject.put("mes",receta.getMes());
            jsonObject.put("dia",receta.getDia());
            randomAccessFile.writeBytes("," + jsonObject.toString() +"\n"+ "]");
            randomAccessFile.close();
        }

    }
}
