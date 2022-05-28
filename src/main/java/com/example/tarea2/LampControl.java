package com.example.tarea2;

import javafx.scene.layout.Pane;

public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel= channel;
        cloud = c;
        view = new LampControlView(this);
    }
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public int getChannel(){
        return channel;
    }
    public void change_Red(short r){ cloud.changeRed(channel,r);}
    public void change_Green(short g){ cloud.changeGreen(channel,g);}
    public void change_Blue(short b){ cloud.changeBlue(channel,b);}
    public Pane getView() { return view;}
    private int channel;
    private Cloud cloud;
    private Pane view;
}
