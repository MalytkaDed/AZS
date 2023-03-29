package org.example;

public class Pump implements OneMinute{
    private byte timePass = 0;
    private int volumeToFill = 0;
    private byte refuelingfSpeed = 20;
    private int timeToFill = 0;
    public boolean freedom = true;

    public void setVolumeToFill(int volumeToFill) {
        this.volumeToFill = volumeToFill;
    }
    public int getTimeToFill(){
        return timeToFill;
    }
    public void startWorking(){
        timeToFill = ((volumeToFill + refuelingfSpeed - 1) / refuelingfSpeed);
        freedom = false;
    }
    @Override
    public void oneMinute(){
        timePass += 1;
        if(timePass == timeToFill + 5){
            timePass = 0;
            volumeToFill = 0;
            freedom = true;
        }
    }

    @Override
    public String toString() {
        return "Pump{" +
                "timePass=" + timePass +
                ", volumeToFill=" + volumeToFill +
                ", refuelingfSpeed=" + refuelingfSpeed +
                ", timeToFill=" + timeToFill +
                ", freedom=" + freedom +
                '}';
    }
}
