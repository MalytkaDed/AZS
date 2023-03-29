package org.example;

public class Car implements OneMinute{
    private int tankVolume;
    private byte tankFulness;
    private int volumeToFill;
    private int waitingTime;
    public boolean resent = false;

    public Car(int tankVolume, byte tankFulness, int volumeToFill) {
        this.tankVolume = tankVolume;
        if((tankFulness < 0) || (tankFulness > 100)){
            throw new RuntimeException("The fulness of the tank must be indicated as a percentage.");
        }
        this.tankFulness = tankFulness;
        if(volumeToFill > (tankVolume * (100 - tankFulness) / 100)){
            throw new RuntimeException("not enough tank capacity");
        }
        this.volumeToFill = volumeToFill;
        waitingTime = 0;
    }

    public int getVolumeToFill() {
        return volumeToFill;
    }
    @Override
    public void oneMinute(){
        waitingTime += 1;
        if(waitingTime == 12){
            resent = true;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "tankVolume=" + tankVolume +
                ", tankFulness=" + tankFulness +
                ", volumeToFill=" + volumeToFill +
                ", waitingTime=" + waitingTime +
                ", resent=" + resent +
                '}';
    }
}
