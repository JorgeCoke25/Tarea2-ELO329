package com.example.tarea2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LampControlView extends VBox {
    public LampControlView(LampControl lampControl) {
        Image img = new Image(getClass().getResource("rsc/powerImage.jpg").toString());
        ImageView view = new ImageView(img);

        BorderPane control= new BorderPane();
        setBackground(new Background(new BackgroundFill(Color.GREEN,new CornerRadii(3),new Insets(-3))));

        Button btn = new Button("",view);
        btn.setOnAction((event)-> lampControl.pressPower());
        control.setCenter(btn);

        VBox vb = new VBox();
        Label label= new Label("On/Off");
        vb.getChildren().add(label);
        vb.setAlignment(Pos.CENTER);
        control.setTop(vb);
        getChildren().add(control);
    }
}
