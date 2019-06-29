/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author minhh
 */
public class MainController implements Initializable {

    @FXML
    private StackPane mainContainer;
    @FXML
    private JFXButton menu1;
    @FXML
    private JFXButton menu2;
    @FXML
    private JFXButton menu3;
    @FXML
    private JFXButton menu4;
    @FXML
    private JFXButton menu5;

    /**
     * Initializes the controller class.
     */
    private final String EXT_FXML = "FXML.fxml";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/Test1FXML.fxml"));
            Parent mainContent = loader.load();
            mainContainer.getChildren().setAll(mainContent);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadScene(String url) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(mainContainer);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished((ActionEvent event) -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
                Parent mainContent = loader.load();
                mainContainer.getChildren().setAll(mainContent);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fadeIntTransion();
        });
        fadeTransition.play();
    }

    private void fadeIntTransion() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(300));
        fadeTransition.setNode(mainContainer);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    @FXML
    private void handlerActionMenu(ActionEvent event) {
        String url = "/ui/" + ((Node) event.getSource()).getAccessibleText() + EXT_FXML;
        loadScene(url);
    }

}
