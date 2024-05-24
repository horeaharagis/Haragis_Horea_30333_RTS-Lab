package LabSession4_LabSession5.Lab5.app3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        List<Integer> sharedList = new ArrayList<>();
        Lock lock = new ReentrantLock(true);
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();

        Producer producerThread = new Producer(sharedList,lock,producerCondition,consumerCondition);
        Consumer consumerThread1 = new Consumer(sharedList,lock,producerCondition,consumerCondition);
        Consumer consumerThread2 = new Consumer(sharedList,lock,producerCondition,consumerCondition);
        Consumer consumerThread3 = new Consumer(sharedList,lock,producerCondition,consumerCondition);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
    }
}
