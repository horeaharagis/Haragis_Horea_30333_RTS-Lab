package LabSession4_LabSession5.Lab7.app3;

import java.util.concurrent.CountDownLatch;

public class Fir extends Thread {

    int sleep, activity_min, activity_max;
    CountDownLatch latch;
    Object lock = new Object();
    Object lock2 = new Object();

    public Fir(int sleep, int activity_min, int activity_max, CountDownLatch latch, Object lock,Object lock2) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.latch = latch;
        this.lock = lock;
        this.lock2 = lock2;
    }

    public void run() {
        System.out.println(this.getName() + " State 1");

            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " State 2");

            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k; i++) {
                i++;
                i--;
            }
        synchronized (lock) {
            lock.notify();
        }

        synchronized (lock2) {
            lock2.notify();
        }
            System.out.println(this.getName() + " State 3");
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

