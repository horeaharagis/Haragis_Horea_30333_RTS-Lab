package LabSession3.app4;

public class ExecutionThread1 extends Thread{
    ExecutionThread thread;
    Integer monitor;
    int activityMin, activityMax;
    public ExecutionThread1(Integer monitor,int activityMin,int activityMax,ExecutionThread thread){
        this.monitor=monitor;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.thread = thread;
    }

    public void run(){
        System.out.println(this.getName()+" State 1");

        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        System.out.println(this.getName()+" State 2");

        int k = (int)Math.round(Math.random()*(activityMax-activityMin)+activityMin);
        for(int i=0;i<k*100000;i++){
            i++;
            i--;
        }
        System.out.println(this.getName()+" State 3");
        if(thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
