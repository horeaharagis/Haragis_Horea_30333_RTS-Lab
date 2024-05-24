package LabSession4_LabSession5.Lab5.app3;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread{
    private List<Integer> sharedList;
    private Lock lock;
    private Condition producerCondition;
    private Condition consumerCondition;

    public Producer(List<Integer> sharedList, Lock lock, Condition producerCondition,Condition consumerCondition){
        this.sharedList = sharedList;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    public void run(){
        Random random = new Random();

        while(true){
            lock.lock();
            try{
                while (sharedList.size()>= 100){
                    producerCondition.await();
                }
                int num = random.nextInt(1000);
                sharedList.add(num);
                System.out.println("Produced: "+num);
                consumerCondition.signalAll();
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
