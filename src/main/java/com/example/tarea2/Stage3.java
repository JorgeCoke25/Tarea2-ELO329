package com.example.tarea2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Stage3 extends Application {
    public void start(Stage primaryStage) {
        Cloud cloud = new Cloud();
        Lamp lamp1 = new Lamp(2);
        Lamp lamp2 =  new Lamp(3);
        cloud.addLamp(lamp1);
        cloud.addLamp(lamp2);
        LampControl lampControl1 = new LampControl(2, cloud);
        LampControl lampControl2 = new LampControl(3,cloud);
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lamp1.getView(), lampControl1.getView(), lamp2.getView(),lampControl2.getView());
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);
        int shadeChannel=2;
        RollerShade rs = new RollerShade(shadeChannel, 2, 150, 100);
        cloud.addRollerShade(rs);
        pane.setCenter(rs.getView());
        ShadeControl shadeControl = new ShadeControl(shadeChannel,cloud);
        hBox.getChildren().add(0,shadeControl.getView());
        Scene scene = new Scene(pane, 600, 350);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
