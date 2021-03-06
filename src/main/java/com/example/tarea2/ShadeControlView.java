package com.example.tarea2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ShadeControlView extends BorderPane {
    public ShadeControlView (ShadeControl sc){
        Button channelButton = new Button(""+sc.getChannel());
        channelButton.setOnAction( e-> {
            sc.stop();
        });
        setCenter(channelButton);
        VBox au = new VBox();
        au.setAlignment(Pos.CENTER);
        Button arrowUP = new Button();
        arrowUP.setOnAction(e->{
            sc.startUp();
        });
        arrowUP.setStyle("-fx-shape: 'M 0 -3.5 v 7 l 4 -3.5 z'; -fx-background-color: green; -fx-stroke: black");
        arrowUP.setRotate(270);
        au.getChildren().add(arrowUP);
        Button arrowDown = new Button();
        arrowDown.setOnAction(e->{
            sc.startDown();
        });
        VBox ad= new VBox();
        ad.setAlignment(Pos.CENTER);
        arrowDown.setStyle("-fx-shape: 'M 0 -3.5 v 7 l 4 -3.5 z';-fx-background-color: green; -fx-stroke: black");
        arrowDown.setRotate(90);
        ad.getChildren().add(arrowDown);
        setTop(au);
        setBottom(ad);
        setBackground(new Background(new BackgroundFill(Color.BLUE,new CornerRadii(5), new Insets(-5))));
    }


}
