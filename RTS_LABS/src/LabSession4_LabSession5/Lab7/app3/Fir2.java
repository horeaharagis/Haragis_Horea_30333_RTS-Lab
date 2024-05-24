package LabSession4_LabSession5.Lab7.app3;

import java.util.concurrent.CountDownLatch;

public class Fir2 extends Thread {
    int sleep, activity_min, activity_max;
    CountDownLatch latch;
    Object lock;

    public Fir2(int sleep, int activity_min, int activity_max, CountDownLatch latch, Object lock) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.latch = latch;
        this.lock = lock;
    }

    public void run() {
        System.out.println(this.getName() + " State 1");
        synchronized (lock) {
            try {

                    Thread.sleep(sleep * 500);

                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


            System.out.println(this.getName() + " State 2");


            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k; i++) {
                i++;
                i--;
            }

            System.out.println(this.getName() + " State 3");
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

