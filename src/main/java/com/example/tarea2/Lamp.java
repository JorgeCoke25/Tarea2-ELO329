package com.example.tarea2;

import javafx.scene.Node;

public class Lamp {
    public Lamp (int channel){
        this.channel= channel;
        r=g=b= 255;
        state = LampState.OFF;
        view = new LampView();
    }
    public int getChannel(){
        return channel;
    }
    public void changePowerState(){
        state = state==LampState.ON ? LampState.OFF : LampState.ON;
        if (state==LampState.OFF) view.setColor((short)0,(short)0, (short)0);
        else view.setColor(r,g,b);
    }

    public short getR() {
        return r;
    }

    public short getG() {
        return g;
    }

    public short getB() {
        return b;
    }

    public void Red(short r) {
        this.r=r;
        if (state==LampState.OFF) view.setColor((short)0,(short)0, (short)0);
        else view.setColor(this.r,g,b);
    }
    public void Green(short g) {
        this.g=g;
        if (state==LampState.OFF) view.setColor((short)0,(short)0, (short)0);
        else view.setColor(r,this.g,b);
    }
    public void Blue(short b) {
        this.b=b;
        if (state==LampState.OFF) view.setColor((short)0,(short)0, (short)0);
        else view.setColor(r,g,this.b);
    }
    public Node getView() {
        return view;
    }
    private int channel;
    private short r,g,b;
    private LampState state;
    private LampView view;
}
