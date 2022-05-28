package com.example.tarea2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LampControlView extends VBox {
    public LampControlView(LampControl lampControl) {
        Image img = new Image(getClass().getResource("rsc/powerImage.jpg").toString());
        ImageView view = new ImageView(img);

        BorderPane control= new BorderPane();
        setBackground(new Background(new BackgroundFill(Color.GREEN,new CornerRadii(3),new Insets(-4))));


        Button btn = new Button("",view);
        btn.setOnAction((event)-> lampControl.pressPower());
        control.setCenter(btn);

        Slider r = new Slider(0,255,255);
        r.setMajorTickUnit(10.0);
        r.setMinorTickCount(5);
        r.setSnapToTicks(true);
        Text vr = new Text(""+(int)r.getValue());
        r.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                vr.setText(""+ (int)r.getValue());
                lampControl.change_Red((short)r.getValue());
            }
        });
        Label lr = new Label("R");
        lr.setFont(new Font(11));
        HBox rh = new HBox(lr,r,vr);
        rh.setAlignment(Pos.CENTER_LEFT);
        Slider g = new Slider(0,255,255);
        g.setMajorTickUnit(10.0);
        g.setMinorTickCount(5);
        g.setSnapToTicks(true);
        Text vg = new Text("255");
        g.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                vg.setText(""+(int)g.getValue());
                lampControl.change_Green((short)g.getValue());
            }
        });
        Label gl = new Label("G");
        gl.setFont(new Font(11));
        HBox gh = new HBox(gl,g,vg);
        Slider b = new Slider(0,255,255);
        b.setMajorTickUnit(10.0);
        b.setMinorTickCount(5);
        b.setSnapToTicks(true);
        Text vbl= new Text("255");
        b.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                vbl.setText(""+(int)b.getValue());
                lampControl.change_Blue((short)b.getValue());
            }
        });
        Label bl = new Label("B");
        bl.setFont(new Font(11));
        HBox bh = new HBox(bl,b,vbl);
        VBox colores = new VBox(rh,gh,bh);
        colores.setSpacing(5);
        control.setBottom(colores);
        VBox vb = new VBox();
        Label label= new Label("On/Off");
        vb.getChildren().add(label);
        vb.setAlignment(Pos.CENTER);
        control.setTop(vb);
        getChildren().add(control);
    }
}
