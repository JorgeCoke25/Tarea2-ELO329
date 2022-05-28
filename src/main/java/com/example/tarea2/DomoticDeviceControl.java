package com.example.tarea2;

import com.example.tarea2.Cloud;

public class DomoticDeviceControl {
    public DomoticDeviceControl(int ch[], Cloud c){
        this.channels=ch;
        this.indexChannel=0;
        this.currentChannel=ch[indexChannel];
        cloud = c;
    }
    public int getChannel() {
        return currentChannel;
    }
    protected Cloud cloud;
    protected int channels[];
    protected int currentChannel;
    protected int indexChannel;
}
