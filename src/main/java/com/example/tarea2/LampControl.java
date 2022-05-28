package com.example.tarea2;

import javafx.scene.layout.Pane;

public class LampControl {
    public LampControl(int channel[], Cloud c){
        this.channels= channel;
        this.indexChannel=0;
        this.currentChannel=channel[indexChannel];
        cloud = c;
        view = new LampControlView(this);
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void pressPower(){
        cloud.changeLampPowerState(currentChannel);
    }
    public void change_Red(short r){ cloud.changeRed(currentChannel,r);}
    public void change_Green(short g){ cloud.changeGreen(currentChannel,g);}
    public void change_Blue(short b){ cloud.changeBlue(currentChannel,b);}
    public Pane getView() { return view;}
    public void changeChannelRight(){
        if(this.currentChannel!=channels[channels.length-1]){
            indexChannel+=1;
            currentChannel=channels[indexChannel];
        }
    }
    public void changeChannelLeft(){
        if(this.currentChannel!=channels[0]){
            indexChannel-=1;
            currentChannel=channels[indexChannel];
        }
    }
    private int channels[];
    private int currentChannel;
    private int indexChannel;
    private Cloud cloud;
    private Pane view;
}
