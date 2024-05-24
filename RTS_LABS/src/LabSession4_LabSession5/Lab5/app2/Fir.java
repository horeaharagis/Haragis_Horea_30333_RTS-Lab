package LabSession4_LabSession5.Lab5.app2;

import java.util.concurrent.Semaphore;

public class Fir extends Thread {
    int name, delay, activity_min,activity_max, permit;
    Semaphore semaphore;

    Fir(int name, Semaphore semaphore, int delay, int activity_min, int activity_max, int permit) {
        this.name = name;
        this.semaphore = semaphore;
        this.delay = delay;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.permit = permit;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Fir " + name + " State 1");
                Thread.sleep(this.delay * 500);
                System.out.println("Fir " + name + " State 2");
                this.semaphore.acquire(this.permit); // critical region
                System.out.println("Fir " + name + " took a token from the semaphore");
                System.out.println("Fir " + name + " State 3");

                int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                this.semaphore.release(); // end of critical region
                System.out.println("Fir " + name + " released a token from the semaphore");
                System.out.println("Fir " + name + " State 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}