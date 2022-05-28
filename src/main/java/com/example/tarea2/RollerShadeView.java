package com.example.tarea2;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.util.Duration;

public class RollerShadeView extends Group {
    public RollerShadeView(double maxLength, double width, double length, double radius,Color color, Media media) {
        MediaPlayer mp = new MediaPlayer(media);
        mp.setAutoPlay(true);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        BorderPane bp = new BorderPane();
        Button mute = new Button("MUTE");
        mute.setOnAction(event -> mp.setMute(!mp.isMute()));
        MediaView mv= new MediaView(mp);
        mv.setFitWidth(width-5);
        bp.setCenter(mv);
        VBox vmute = new VBox();
        vmute.getChildren().add(mute);
        vmute.setAlignment(Pos.CENTER);
        bp.setRight(vmute);
        bp.setLayoutX(2.5);
        getChildren().add(bp);

        cloth = new Rectangle (0,5,width,length);
        cloth.setFill(color);
        cloth.setStroke(Color.BLACK);
        getChildren().add(cloth);

        // Rolled up shade cloth
        Ellipse rightSide = new Ellipse(width, radius,radius/2,radius);
        rightSide.setFill(color);
        rightSide.setStroke(Color.BLACK);
        getChildren().add(rightSide);

        Ellipse leftsize = new Ellipse(0, radius,radius/2,radius);
        leftsize.setFill(color);
        leftsize.setStroke(Color.BLACK);
        getChildren().add(leftsize);

        Rectangle stick = new Rectangle(0,0,width,radius*2);
        stick.setFill(color);
        getChildren().add(stick);
    }
    public void setLength(double length) {
        cloth.setHeight(length);
    }
    private Rectangle cloth;
}
