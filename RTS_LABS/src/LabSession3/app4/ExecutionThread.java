package LabSession3.app4;

public class ExecutionThread extends Thread{
    Integer monitor1;
    Integer monitor2;
    int activityMin,activityMax,sleep;
    public ExecutionThread(Integer monitor1,Integer monitor2,int activityMin,int activityMax,int sleep){
        this.monitor1=monitor1;
        this.monitor2=monitor2;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.sleep = sleep;
    }

    public synchronized void waitNotify(String name) throws InterruptedException{
        System.out.println(name+" waits");
        wait();
    }

    public void run(){
        System.out.println(this.getName()+" State 1");

        try {
            Thread.sleep(500 * sleep);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this.getName()+" State 2");

        int k = (int)Math.round(Math.random()*(activityMax-activityMin)+activityMin);
        for(int i=0;i<k*100000;i++){
            i++;
            i--;
        }
        synchronized(monitor1){
            monitor1.notify();
        }
        synchronized(monitor2){
            monitor2.notify();
        }
        System.out.println(this.getName()+" State 3");

    }

}
