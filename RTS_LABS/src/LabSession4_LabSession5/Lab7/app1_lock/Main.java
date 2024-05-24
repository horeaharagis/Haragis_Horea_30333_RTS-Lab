package LabSession4_LabSession5.Lab7.app1_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();


            Fir thread1 = new Fir(lock1,lock2,2,4,4,6,4);
            Fir thread2 = new Fir(lock2,lock1,3,5,5,7,5);

            thread1.start();
            thread2.start();

    }
}

