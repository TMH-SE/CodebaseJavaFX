/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Screen;
import javafx.stage.StageStyle;

/**
 *
 * @author minhh
 */
public class ThongBao {

    public static void thongBaoLoi(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.initStyle(StageStyle.DECORATED);
        DialogPane pane = alert.getDialogPane();
        pane.setMinHeight(100.0);
        alert.setWidth(pane.getWidth());
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        alert.setX(bounds.getMaxX() - alert.getWidth() - 75);
        alert.setY(bounds.getMaxY() - pane.getMinHeight() - 75);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void thongBaoThanhCong(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.initStyle(StageStyle.DECORATED);
        DialogPane pane = alert.getDialogPane();
        pane.setPrefHeight(100.0);
        alert.setWidth(pane.getWidth());
        Rectangle2D bounds = Screen.getPrimary().getBounds();
        alert.setX(bounds.getMaxX() - alert.getWidth() - 75);
        alert.setY(bounds.getMaxY() - pane.getPrefHeight() - 75);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
