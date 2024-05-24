package LabSession3.app3;

public class ExecutionThread extends Thread{
    Integer monitor;
    int activityMin,activityMax,sleep;

    public ExecutionThread(Integer monitor,int activityMin,int activityMax,int sleep){
        this.monitor = monitor;
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.sleep = sleep;
    }

    public void run(){

        while(true){
            System.out.println(this.getName()+" STATE 1");
            synchronized(monitor){
                System.out.println(this.getName()+" STATE 2");
                int k=(int)Math.round(Math.random()*(activityMax-activityMin)+activityMin);
                for (int i=0;i<k*100000;i++){
                    i++;
                    i--;
                }
            }
            System.out.println(this.getName()+" STATE 3");
            try {
                Thread.sleep(sleep * 500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(this.getName()+" STATE 4");

        }
    }

}
