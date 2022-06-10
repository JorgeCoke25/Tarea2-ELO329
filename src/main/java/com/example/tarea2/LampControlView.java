package com.example.tarea2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        Image img = new Image("https://www.freeiconspng.com/thumbs/power-button-icon/power-button-icon-31.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(50);
        view.setPreserveRatio(true);

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
        HBox channels = new HBox();
        Label label= new Label(""+lampControl.getCurrentChannel());
        Button left= new Button();
        left.setStyle("-fx-shape: 'M 0 -3.5 v 7 l 4 -3.5 z';-fx-background-color: blue; -fx-stroke: black; ");
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lampControl.changeChannelLeft();
                label.setText(""+lampControl.getCurrentChannel());
            }
        });
        Button right=new Button();
        right.setStyle("-fx-shape: 'M 0 -3.5 v 7 l 4 -3.5 z';-fx-background-color: blue; -fx-stroke: black");
        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lampControl.changeChannelRight();
                label.setText(""+lampControl.getCurrentChannel());
            }
        });
        left.setRotate(180);
        channels.getChildren().addAll(left,label,right);
        channels.setSpacing(10);
        channels.setAlignment(Pos.CENTER);
        channels.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(3),new Insets(0,50,0,50))));
        control.setTop(channels);
        getChildren().add(control);
    }
}
