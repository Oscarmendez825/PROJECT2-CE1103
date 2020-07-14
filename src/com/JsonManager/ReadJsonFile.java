package com.JsonManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadJsonFile {
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
                long el = (Long) obj.get("E_LEVEL");
                System.out.println("Emergency Level : " + el);
                long depth = (Long) obj.get("DEPTH");
                System.out.println("Depth : " + depth);
                long i = (Long) obj.get("INTENSITY");
                System.out.println("Intensity :"+i);
                System.out.println("\n");
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
