package LabSession4_LabSession5.Lab7.app3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(1);
        Object lock = new Object();
        Object lock2 = new Object();

        Fir thread1 = new Fir(7,2,3,latch,lock,lock2);
        Fir2 thread2 = new Fir2(5,3,5,latch,lock);
        Fir2 thread3 = new Fir2(5,4,6,latch,lock2);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
