package com.example.tarea2;

import com.example.tarea2.Cloud;
import javafx.scene.layout.BorderPane;

public class ShadeControl extends DomoticDeviceControl{
    public ShadeControl(int channels[], Cloud c){
        super(channels,c);
        view = new ShadeControlView(this);
    }
    public BorderPane getView() {return view;}
    public void startUp(){
        cloud.startShadeUp(getChannel());
    }

    public void startDown(){
        cloud.startShadeDown(getChannel());
    }
    public void changeChannelLeft(){
        if(this.currentChannel!=channels[0]){
            indexChannel-=1;
            currentChannel=channels[indexChannel];
        }
    }
    public void changeChannelRight(){
        if(this.currentChannel!=channels[channels.length-1]){
            indexChannel+=1;
            currentChannel=channels[indexChannel];
        }
    }
    public void stop(){
        cloud.stopShade(getChannel());
    }

    private ShadeControlView view;
}
