package LabSession4_LabSession5.Lab5.app2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore =new Semaphore(4);
        Fir f1 = new Fir(1,semaphore,2,2,5,2);
        Fir f2 = new Fir(2,semaphore,4,3,6,2);

        f1.start();
        f2.start();
    }
}
