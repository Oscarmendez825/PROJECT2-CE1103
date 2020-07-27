package com.JsonManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
/***
 * Class used for change data inside a Json file.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class CambiarValorJson {

    /***
     * This method modifies the stored password of a certain user.
     * @param nombre String
     * @param pass String
     */
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
    /***
     * This method adds a follower to a certain user.
     * @param usuario String
     * @param seguidor String
     */
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
    /***
     * This method adds a certain user as a member of a company.
     * @param usuario String
     * @param nameEmpresa String
     */
    public static void agregarEmpresa(String usuario, String nameEmpresa){
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
                JSONArray empresa = (JSONArray)obj.get("empresa");

                if (name.equals(usuario)){
                    empresa.add(nameEmpresa);
                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("password",password);
                    jsonObjectG.put("email",email);
                    jsonObjectG.put("edad",edad);
                    jsonObjectG.put("chef", chef);
                    jsonObjectG.put("seguidores",seguidores);
                    jsonObjectG.put("seguidos",seguidos);
                    jsonObjectG.put("empresa",empresa);

                    temp.add(jsonObjectG);

                }else{
                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("password",password);
                    jsonObjectG.put("email",email);
                    jsonObjectG.put("edad",edad);
                    jsonObjectG.put("chef", chef);
                    jsonObjectG.put("seguidores",seguidores);
                    jsonObjectG.put("seguidos",seguidos);
                    jsonObjectG.put("empresa",empresa);
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
    /***
     * This method adds a follower to a certain company.
     * @param empresa String
     * @param seguidor String
     */
    public static void seguidorEmpresa(String seguidor,String empresa){
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONEmpresas.json"));
            JSONArray temp = new JSONArray();
            for (Object o : a)
            {
                JSONObject jsonObjectG = new JSONObject();
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nombre");
                String contacto = (String) obj.get("contacto");
                String horario = (String) obj.get("horario");
                JSONArray seguidores = (JSONArray) obj.get("seguidores");
                if (name.equals(empresa)){
                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("contacto",contacto);
                    jsonObjectG.put("horario",horario);
                    seguidores.add(seguidor);
                    jsonObjectG.put("seguidores",seguidores);

                    temp.add(jsonObjectG);

                }else{
                    jsonObjectG.put("nombre",name);
                    jsonObjectG.put("contacto",contacto);
                    jsonObjectG.put("horario",horario);
                    jsonObjectG.put("seguidores",seguidores);
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
