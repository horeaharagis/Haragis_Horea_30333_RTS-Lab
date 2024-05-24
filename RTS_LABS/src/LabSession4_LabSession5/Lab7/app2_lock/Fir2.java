package LabSession4_LabSession5.Lab7.app2_lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir2 extends Thread {
    int activity_min, activity_max, sleep;
    Lock lock1;
    Lock lock2;
    CountDownLatch latch;

    public Fir2(int activity_min, int activity_max, int sleep, Lock lock1, Lock lock2, CountDownLatch latch) {
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep = sleep;
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.latch = latch;

    }

    public void run() {

            System.out.println(this.getName() + " State 1");

                lock1.lock();

                    lock2.lock();
                    System.out.println(this.getName() + " State 2");
                    int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                    for (int i = 0; i < k * 100000; i++) {
                        i++;
                        i--;
                    }


                    lock2.unlock();


                lock1.unlock();


            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
