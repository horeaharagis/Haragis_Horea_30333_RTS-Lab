package LabSession4_LabSession5.Lab5.app1;

import java.util.concurrent.locks.Lock;

class Fir extends Thread{
    int name;
    Lock lock;

    Fir(int name, Lock lock){
        this.name = name;
        this.lock = lock;
    }

    public void run() {

        this.lock.lock();
        System.out.println("The thread "+name+" acquired the lock");
        criticalRegion();
        this.lock.unlock();
        System.out.println("The thread "+name+" released the lock");
    }

    public void criticalRegion(){
        System.out.println("IS EXECUTING THE CRITICAL REGION");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
