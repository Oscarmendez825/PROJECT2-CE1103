package com.JsonManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class CambiarValorJson {
    public static void cambiarPassword(String nombre, String pass){
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json"));
            JSONArray temp = new JSONArray();
            for (Object o : a)
            {
                JSONObject jsonObjectG = new JSONObject();
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nombre");
                String password = (String) obj.get("password");
                long edad = (long) obj.get("edad");
                Boolean chef = (Boolean) obj.get("chef");
                String email = (String) obj.get("email");
                JSONArray seguidos = (JSONArray) obj.get("seguidos");
                JSONArray seguidores = (JSONArray) obj.get("seguidores");


                if (name.equals(nombre)){

                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("password",pass);
                    jsonObjectG.put("email",email);
                    jsonObjectG.put("edad",edad);
                    jsonObjectG.put("chef", chef);
                    jsonObjectG.put("seguidores",seguidores);
                    jsonObjectG.put("seguidos",seguidos);
                    temp.add(jsonObjectG);

                }else{
                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("password",password);
                    jsonObjectG.put("email",email);
                    jsonObjectG.put("edad",edad);
                    jsonObjectG.put("chef", chef);
                    jsonObjectG.put("seguidores",seguidores);
                    jsonObjectG.put("seguidos",seguidos);
                    temp.add(jsonObjectG);

                }
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json"));
                bw.write("");
                bw.close();
                FileWriter file = new FileWriter("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json");
                file.write(temp.toString());
                file.flush();
                file.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void agregarSeguidor(String usuario, String seguidor){
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json"));
            JSONArray temp = new JSONArray();
            for (Object o : a)
            {
                JSONObject jsonObjectG = new JSONObject();
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nombre");
                String password = (String) obj.get("password");
                long edad = (long) obj.get("edad");
                Boolean chef = (Boolean) obj.get("chef");
                String email = (String) obj.get("email");
                JSONArray seguidos = (JSONArray) obj.get("seguidos");
                JSONArray seguidores = (JSONArray) obj.get("seguidores");


                if (name.equals(usuario)){

                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("password",password);
                    jsonObjectG.put("email",email);
                    jsonObjectG.put("edad",edad);
                    jsonObjectG.put("chef", chef);
                    seguidores.add(seguidor);
                    jsonObjectG.put("seguidores",seguidores);
                    jsonObjectG.put("seguidos",seguidos);
                    temp.add(jsonObjectG);

                }else if(name.equals(seguidor)){
                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("password",password);
                    jsonObjectG.put("email",email);
                    jsonObjectG.put("edad",edad);
                    jsonObjectG.put("chef", chef);
                    seguidos.add(usuario);
                    jsonObjectG.put("seguidores",seguidores);
                    jsonObjectG.put("seguidos",seguidos);
                    temp.add(jsonObjectG);

                } else{
                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("password",password);
                    jsonObjectG.put("email",email);
                    jsonObjectG.put("edad",edad);
                    jsonObjectG.put("chef", chef);
                    jsonObjectG.put("seguidores",seguidores);
                    jsonObjectG.put("seguidos",seguidos);
                    temp.add(jsonObjectG);

                }
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json"));
                bw.write("");
                bw.close();
                FileWriter file = new FileWriter("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json");
                file.write(temp.toString());
                file.flush();
                file.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
