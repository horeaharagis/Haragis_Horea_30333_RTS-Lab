package LabSession4_LabSession5.Lab7.app2_lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

       CountDownLatch latch ;
       while(true) {
           latch = new CountDownLatch(4);
           Fir thread1 = new Fir(2, 4, 4, lock1, latch);
           Fir2 thread2 = new Fir2(3, 6, 3, lock1, lock2, latch);
           Fir thread3 = new Fir(2, 5, 5, lock2, latch);

           thread1.start();
           thread2.start();
           thread3.start();
           latch.countDown();
           latch.await();
       }
    }
}
