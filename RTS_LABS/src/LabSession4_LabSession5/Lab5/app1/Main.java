package LabSession4_LabSession5.Lab5.app1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) {
       Lock lock = new ReentrantLock();
       Fir f1 = new Fir(1,lock);
       Fir f2 = new Fir(2,lock);
       f1.start();
       f2.start();
    }
}