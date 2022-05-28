package com.example.tarea2;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LampControlView extends VBox {
    public LampControlView(LampControl lampControl) {
        Image img = new Image(getClass().getResource("rsc/powerImage.jpg").toString());
        ImageView view = new ImageView(img);

        BorderPane control= new BorderPane();
        control.setStyle("-fx-background-color: green");

        Button btn = new Button("",view);
        btn.setOnAction((event)-> lampControl.pressPower());
        control.setCenter(btn);

        Label label= new Label("On/Off");
        control.setTop(label);

        getChildren().add(control);
    }
}
