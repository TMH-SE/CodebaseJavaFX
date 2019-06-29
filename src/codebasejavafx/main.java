/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebasejavafx;

import controllers.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author minhh
 */
public class main extends Application {
    
    public static Stage mainStage;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        mainStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/MainFXML.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        mainStage.setScene(new Scene(root));
        mainStage.setFullScreen(false);
        mainStage.setResizable(false);
//        mainStage.setTitle("CD");
//        mainStage.getIcons().add(e);
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
