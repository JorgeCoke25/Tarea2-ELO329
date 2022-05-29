package com.example.tarea2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.stage.Stage;

public class Stage4 extends Application {
    public void start(Stage primaryStage) {
        Media media1 = new Media("http://profesores.elo.utfsm.cl/~agv/elo329/1s22/Assignments/20220430_100849.mp4");
        Media media2 = new Media("http://profesores.elo.utfsm.cl/~agv/elo329/1s22/Assignments/20220430_101027.mp4");
        Cloud cloud = new Cloud();
        int lampcanales[] = {1,2};
        int shadeCanales[]={1,2};
        Lamp lamp1 = new Lamp(lampcanales[0]);
        Lamp lamp2 =  new Lamp(lampcanales[1]);
        cloud.addLamp(lamp1);
        cloud.addLamp(lamp2);
        LampControl lampControl = new LampControl(lampcanales, cloud);
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lamp1.getView(), lamp2.getView(), lampControl.getView());
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);
        RollerShade rs1 = new RollerShade(shadeCanales[0], 2, 150, 150,media1);
        RollerShade rs2 = new RollerShade(shadeCanales[1], 4, 360, 202.5,media2);
        cloud.addRollerShade(rs1);
        cloud.addRollerShade(rs2);
        HBox hBox1 = new HBox(20);
        hBox1.setPadding((new Insets(20)));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(rs1.getView(), rs2.getView());
        pane.setCenter(hBox1);
        ShadeControl shadeControl = new ShadeControl(shadeCanales, cloud);
        hBox.getChildren().add(0,shadeControl.getView());
        Scene scene = new Scene(pane, 720, 480);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}
