package com.example.tarea2;

import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
        rollerShades = new ArrayList<DomoticDevice>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }

    public Lamp getLampAtChannel( int channel){
        for (Lamp l: lamps)
            if (l.getChannel() ==channel)
                return l;
        return null;
    }
    public void changeRed(int channel,short r){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.Red(r);
            }
        }
    }
    public void changeGreen(int channel,short g){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.Green(g);
            }
        }
    }
    public void changeBlue(int channel, short b){
        for (Lamp lamp : lamps) {
            if (lamp.getChannel()==channel) {
                lamp.Blue(b);
            }
        }
    }
    public void changeLampPowerState(int channel){
        Lamp l=getLampAtChannel(channel);
        if (l != null) l.changePowerState();
    }
    private ArrayList<DomoticDevice> getDomoticDeviceAtChannel( ArrayList<DomoticDevice> devices, int channel){
        ArrayList<DomoticDevice> domoticDevicesChannel;
        domoticDevicesChannel = new ArrayList<DomoticDevice>();
        for (DomoticDevice domoticDevice : devices) {
            if (domoticDevice.getChannel()==channel){
                domoticDevicesChannel.add(domoticDevice);
            }
        }
        return domoticDevicesChannel;
    }
    public void startShadeUp(int channel){
        ArrayList<DomoticDevice> domoticDevices;
        domoticDevices = getDomoticDeviceAtChannel(rollerShades, channel);
        for (DomoticDevice dd : domoticDevices) {
            RollerShade rs=(RollerShade)dd;
            rs.startUp();
        }
    }
    public void startShadeDown(int channel){
        ArrayList<DomoticDevice> domoticDevices;
        domoticDevices = getDomoticDeviceAtChannel(rollerShades, channel);
        for (DomoticDevice dd : domoticDevices) {
            RollerShade rs=(RollerShade)dd;
            rs.startDown();
        }
    }
    public void stopShade(int channel){
        ArrayList<DomoticDevice> domoticDevices;
        domoticDevices = getDomoticDeviceAtChannel(rollerShades, channel);
        for (DomoticDevice dd : domoticDevices) {
            RollerShade rs=(RollerShade)dd;
            rs.stop();
        }
    }
    private ArrayList<Lamp> lamps;
    private ArrayList<DomoticDevice> rollerShades;
}
