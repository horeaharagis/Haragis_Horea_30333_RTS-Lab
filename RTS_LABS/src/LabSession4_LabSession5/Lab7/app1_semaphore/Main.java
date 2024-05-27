package LabSession4_LabSession5.Lab7.app1_semaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("Barrier reached by all threads. Continuing execution.");
        });


        while (true) {
            Fir thread1 = new Fir(2, 4, 4, 6, 4, 1, semaphore, semaphore2, barrier);
            Fir thread2 = new Fir(3, 5, 5, 7, 5, 1, semaphore2, semaphore, barrier);

            thread1.start();
            thread2.start();

            barrier.await();
            barrier.reset();
        }

    }
}
