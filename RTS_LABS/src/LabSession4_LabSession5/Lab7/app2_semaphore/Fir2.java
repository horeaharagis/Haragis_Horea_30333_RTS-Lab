package LabSession4_LabSession5.Lab7.app2_semaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir2 extends Thread {
    int activity_min, activity_max, sleep;
    Semaphore semaphore1;
    Semaphore semaphore2;
    CyclicBarrier barrier;

    public Fir2(int activity_min, int activity_max, int sleep, Semaphore semaphore1, Semaphore semaphore2, CyclicBarrier barrier) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.semaphore1 = semaphore1;
        this.semaphore2 = semaphore2;
        this.barrier = barrier;

    }

    public void run() {
        while (true) {
            try {
                System.out.println(this.getName() + " State 1");
                semaphore1.acquire(1);
                semaphore2.acquire(1);
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
                semaphore1.release();
                semaphore2.release();
            } catch (InterruptedException e) {
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
