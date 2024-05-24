package LabSession4_LabSession5.Lab7.app4;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Fir thread1 = new Fir(3,6,5,semaphore);
        Fir thread2 = new Fir(4,7,3,semaphore);
        Fir thread3 = new Fir(5,7,6,semaphore);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
