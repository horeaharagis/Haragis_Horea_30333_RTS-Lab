package LabSession3.app2;


import LabSession3.app2.ExecutionThread;

public class Main {
    public static void main(String[] args){
        Integer monitor = new Integer(1);
        Integer monitor2 = new Integer(1);
        new ExecutionThread(monitor,monitor2,2,4,4,6,4).start();
        new ExecutionThread(monitor2,monitor,3,5,5,7,5).start();
    }
}
