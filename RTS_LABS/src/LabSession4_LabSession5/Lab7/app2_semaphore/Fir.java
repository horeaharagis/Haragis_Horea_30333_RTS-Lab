package LabSession4_LabSession5.Lab7.app2_semaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir extends Thread {
    int activity_min, activity_max, sleep;
    Semaphore semaphore;
    CyclicBarrier barrier;

    public Fir(int activity_min, int activity_max, int sleep, Semaphore semaphore, CyclicBarrier barrier) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.semaphore = semaphore;
        this.barrier = barrier;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(this.getName() + " State 1");
                semaphore.acquire(1);
                System.out.println(this.getName() + " State 2");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }

                try {
                    Thread.sleep(sleep * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(this.getName() + " State 3");
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }
}