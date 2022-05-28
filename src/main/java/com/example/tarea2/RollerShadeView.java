package com.example.tarea2;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class RollerShadeView extends Group {
    public RollerShadeView(double maxLength, double width, double length, double radius, Color color) {
        Rectangle background = new Rectangle(5,5, width-10,maxLength-5);
        background.setFill(Color.BLUE);  // I chose Blue
        getChildren().add(background);

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
