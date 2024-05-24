package LabSession3.app4;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);
        ExecutionThread thread1 = new ExecutionThread(monitor1, monitor2, 2, 3, 7 );
        ExecutionThread1 thread2 = new ExecutionThread1(monitor1, 3,5, thread1);
        ExecutionThread1 thread3 = new ExecutionThread1(monitor2, 4, 6, thread1);
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
