package LabSession4_LabSession5.Lab7.app1_semaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir extends Thread {
    int activity_min, activity_max, activity_min1, activity_max1, sleep, permit;
    Semaphore semaphore;
    Semaphore semaphore2;
    CyclicBarrier barrier;


    public Fir(int activity_min, int activity_max, int activity_min1, int activity_max1, int sleep, int permit, Semaphore semaphore, Semaphore semaphore2, CyclicBarrier barrier) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.activity_min1 = activity_min1;
        this.activity_max1 = activity_max1;
        this.sleep = sleep;
        this.permit = permit;
        this.semaphore = semaphore;
        this.barrier = barrier;
        this.semaphore2 = semaphore2;
    }

    public void run() {

            System.out.println(this.getName() + " State 1");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        try {
            this.semaphore.acquire(this.permit);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + " State 2");
            int k1 = (int) Math.round(Math.random() * (activity_max1 - activity_min1) + activity_min1);
            for (int i = 0; i < k1 * 100000; i++) {
                i++;
                i--;
            }
            if (semaphore2.tryAcquire(1)) {
                try {
                    System.out.println(this.getName() + " State 3");
                    Thread.sleep(sleep * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore2.release(1);
                }

            }
                this.semaphore.release(1);
                System.out.println(this.getName() + " State 4");


                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

        }
    }

