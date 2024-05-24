package LabSession4_LabSession5.Lab5.app3;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread {
    private List<Integer> sharedList;
    private Lock lock;
    private Condition producerCondition;
    private Condition consumerCondition;

    public Consumer(List<Integer> sharedList, Lock lock, Condition producerCondition, Condition consumerCondition){
        this.sharedList = sharedList;
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    public void run(){
        while(true) {
            lock.lock();
            try{
                while (sharedList.isEmpty()){
                    consumerCondition.await();
                }
                int num = sharedList.remove(0);
                System.out.println(this.getName()+" consumed: "+num);
                producerCondition.signal();
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
