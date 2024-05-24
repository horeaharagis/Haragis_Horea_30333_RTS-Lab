package LabSession3.app2;

public class ExecutionThread extends Thread{
    Integer monitor;
    Integer monitor2;
    int activityMin,activityMax,sleep;
    int activityMin1,activityMax1;

    public ExecutionThread(Integer monitor, Integer monitor2,int activityMin,int activityMax, int activityMin1,int activityMax1, int sleep){
        this.monitor=monitor;
        this.monitor2=monitor2;
        this.activityMin=activityMin;
        this.activityMax=activityMax;
        this.activityMin1=activityMin1;
        this.activityMax1=activityMax1;
        this.sleep = sleep;
    }
    public void run(){
        System.out.println(this.getName()+" STATE 1");
        int k =(int)Math.round(Math.random()*(activityMax-activityMin)+activityMin);
        for (int i=0; i<k*100000;i++){
            i++;
            i--;
        }
        synchronized (monitor){
            System.out.println(this.getName()+" STATE 2");
            int k1 =(int)Math.round(Math.random()*(activityMax1-activityMin1)+activityMin1);
            for (int i=0; i<k1*100000;i++){
                i++;
                i--;
            }
        }


        synchronized (monitor2){
            System.out.println(this.getName()+" STATE 3");
            try {
                Thread.sleep(sleep * 500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+" STATE 4");

    }
}
