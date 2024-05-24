package LabSession4_LabSession5.Lab7.app4;

import java.util.concurrent.Semaphore;

public class Fir extends Thread {
    int activity_min, activity_max, sleep;
    Semaphore semaphore;

    public Fir(int activity_min, int activity_max, int sleep, Semaphore semaphore) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.semaphore = semaphore;
    }

    public void run() {
        while (true) {

            System.out.println(this.getName() + " State 1");
            try {
                this.semaphore.acquire(1);
                System.out.println(this.getName() + " State 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                this.semaphore.release(1);
                System.out.println(this.getName() + " State 3");
                try {
                    Thread.sleep(500 * sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + " State 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
