package com.sample2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/***
 * Class of primary settings for the user manager interface.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Main2 extends Application implements Runnable {
    /***
     * This method sets the primarysettings of the user management interface.
     * @param primaryStage String
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("COOKTIME SERVER MANAGER");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    /***
     * Main method of the 'Main2' class
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    /***
     * 'Main2' launcher.
     */
    @Override
    public void run() {
        Main2.launch();
    }
}
