package LabSession4_LabSession5.Lab7.app2_semaphore;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);

        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("Barrier reached by all threads. Continuing execution.");
        });

        Fir thread1 = new Fir(2,4,4,semaphore1,barrier);
        Fir2 thread2 = new Fir2(3,6,3,semaphore1,semaphore2,barrier);
        Fir thread3 = new Fir(2,5,5,semaphore2,barrier);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
