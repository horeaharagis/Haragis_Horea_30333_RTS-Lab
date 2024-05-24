package LabSession4_LabSession5.Lab5.lab4_app2;

import java.util.concurrent.locks.Lock;

public class Fir extends Thread {
    Lock lock1;
    Lock lock2;
    int activity_min, activity_max, activity_min1, activity_max1, sleep;

    public Fir(Lock lock1, Lock lock2, int activity_min, int activity_max, int activity_min1, int activity_max1, int sleep) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.activity_min1 = activity_min1;
        this.activity_max1 = activity_max1;
        this.sleep = sleep;
    }

    public void run() {

        System.out.println(this.getName() + " - State 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        if (lock1.tryLock()) {
            try {

                System.out.println(this.getName() + " - acquired the lock1");
                System.out.println(this.getName() + " - State 2");
                int k1 = (int) Math.round(Math.random() * (activity_max1 - activity_min1) + activity_min1);
                for (int i = 0; i < k1 * 100000; i++) {
                    i++;
                    i--;
                }
                if (lock2.tryLock()) {
                    try {
                        System.out.println(this.getName() + " - acquired the lock2");
                        System.out.println(this.getName() + " - State 3");
                        try {
                            Thread.sleep(sleep * 500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        lock2.unlock();
                        System.out.println(this.getName() + " - released the lock2");
                    }
                } else {
                    System.out.println(this.getName() + " - failed to acquire lock2");
                }
            } finally {
                lock1.unlock();
                System.out.println(this.getName() + " - released the lock1");

            }
        }else {
            System.out.println(this.getName() + " - failed to acquire lock1");
        }
        System.out.println(this.getName() + " - State 4");

    }
}
