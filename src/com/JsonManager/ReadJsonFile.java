package com.JsonManager;

import com.google.gson.annotations.JsonAdapter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/***
 * Class destined to read the data stored in Json files.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class ReadJsonFile {
    /***
     * This method reads the content of a certain Json file.
     */
    public static void leerJson(){
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json"));
            for (Object o : a)
            {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nombre");
                System.out.println("nombre : " + name);
                String password = (String) obj.get("password");
                System.out.println("password : " + password);
                long edad = (long) obj.get("edad");
                System.out.println("edad: " + edad);
                Boolean chef = (Boolean) obj.get("chef");
                System.out.println("chef : " + chef);
                String email = (String) obj.get("email");
                System.out.println("email :"+email);
                JSONArray seguidos = (JSONArray) obj.get("seguidos");
                for(Object i : seguidos){
                    JSONObject jsonObject = (JSONObject) i;
                    String name2 = (String) jsonObject.get("nombre");
                    System.out.println("nombre : " + name2);
                    String email2 = (String) jsonObject.get("email");
                    System.out.println("email :"+email2);

                }
                System.out.println("/n");
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
