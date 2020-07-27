package com.sample2;

import com.UsuariosManager.RegistroUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/***
 * User management interface.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Controller2 implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    @FXML
    private VBox field;

    @FXML
    private Button updateButton;

    @FXML
    private ListView<String> userList;

    /***
     * This method sets the event for the charge of users from the Json file to the BST tree.
     * @param event MouseEvent
     */
    @FXML
    void cargarUsuarios(MouseEvent event) {
        RegistroUsuario r = new RegistroUsuario();
        r.cargarDatos();
        JOptionPane.showMessageDialog(null,"DATA CHARGED CORRECTLY");
    }
    /***
     * This event sets the event for assign to an user the "chef" status.
     * @param event MouseEvent
     */
    @FXML
    void selectedUser(MouseEvent event) {
        String user = userList.getSelectionModel().getSelectedItem();
        if(user == null || user.isEmpty()){
            JOptionPane.showMessageDialog(null,"YOU DID NOT SELECTED NOTHING");
        }else{
            JOptionPane.showMessageDialog(null,user+" IS NOW CHEF!!");
        }
    }
    /***
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }
    private void loadData(){
        list.removeAll(list);
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\Project2CE1103\\JSONuser.json"));
            for (Object o : a)
            {
                JSONObject obj = (JSONObject) o;
                String name = (String) obj.get("nombre");
                list.add(name);
            }userList.getItems().addAll(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
