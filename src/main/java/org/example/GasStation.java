package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GasStation implements OneMinute{
     private int allFuel = 20000;
     private ArrayList<Car> queue = new ArrayList<>();
     private ArrayList<Pump> pumps = new ArrayList<>();
     private Pump pump1 = new Pump();
     private Pump pump2 = new Pump();
     public void startWorking(){
          pumps.add(pump1);
          pumps.add(pump2);
     }

     private int carSpawnChance = 25;
     private void newPump(){
          Pump pump = new Pump();
          pumps.add(pump);
     }
     public void refill(){
          allFuel += 20000;
     }
     @Override
     public void oneMinute(){
          pumps.stream().filter(pump -> !(pump.freedom)).forEach(pump -> pump.oneMinute());
          queue.stream().forEach(car -> car.oneMinute());
          for (Pump pump : pumps){
               if(pump.freedom){
                    if(!(queue.isEmpty())){
                         Car car = queue.get(0);
                         pump.setVolumeToFill(car.getVolumeToFill());
                         pump.startWorking();
                         queue.remove(0);
                    }
               }
          }

          if(Math.random() * 100 < carSpawnChance){
               int tankVolume = (int)(Math.random() * 80 + 50);
               byte tankFulness = (byte)(Math.random()*40 + 10);
               int maxVolumeToFill = (tankVolume * (100 - tankFulness) / 100) - 25;
               int volumeToFill = (int)(Math.random() * maxVolumeToFill + 25);
               Car car = new Car(tankVolume,tankFulness,volumeToFill);

               Optional<Pump> freePump = pumps.stream().filter(pump -> pump.freedom).findFirst();
               if(freePump.isEmpty()){
                    queue.add(car);
               }
               else{
                    Pump pump = freePump.get();
                    pump.setVolumeToFill(volumeToFill);
                    pump.startWorking();
               }
          }
     }

     @Override
     public String toString() {
          return "Cars in queue " + Integer.toString(queue.size()) + "\nPumps working: " + pump1.freedom + " " + pump2.freedom ;
     }
}
