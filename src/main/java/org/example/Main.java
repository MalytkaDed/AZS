package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GasStation AZS = new GasStation();
        AZS.startWorking();

        int oneMinute = 1;
        int oneHour = 3600;
        int oneDay = 86400;
        int i;
        for (i = 0; i < 10000000; i++){
            if (i % (2 * oneDay) == 0) {
                AZS.refill();
            }
            if ((i > oneDay) && (i < oneDay + oneHour)) {
                Thread.sleep(500);
                AZS.oneMinute();
                System.out.println(AZS);
                System.out.println("////////////////////////");
            }
            else{
                AZS.oneMinute();
            }
        }
    }
}