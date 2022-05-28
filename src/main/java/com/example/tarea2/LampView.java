package com.example.tarea2;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class LampView extends Group {
    public LampView () {
        Polygon base = new Polygon();
        base.getPoints().addAll(new Double[]{
                18d, 20d,
                18d, 50d,
                13d, 50d,
                10d, 53d,
                10d, 60d,
                30d, 60d,
                30d, 53d,
                27d, 50d,
                22d, 50d,
                22d, 20d});
        base.setFill(Color.GREEN);
        Polygon top = new Polygon();
        top.getPoints().addAll(new Double[]{
                5d,-20d,
                35d,-20d,
                50d,20d,
                -10d,20d
        });
        top.setStyle("-fx-stroke: black");
        top.setFill(Color.rgb(0,0,0));
        this.lampshade=top;
        getChildren().addAll(base,lampshade);
    }
    public void setColor(short r, short g, short b){
        this.lampshade.setFill(Color.rgb(r,g,b));
    }
    private Polygon lampshade;
}
