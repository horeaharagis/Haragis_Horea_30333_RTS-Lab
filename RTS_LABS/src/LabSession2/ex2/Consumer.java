package LabSession2.ex2;

public class Consumer extends Thread{
    private Buffer bf;

    public Consumer(Buffer bf) {
        this.bf = bf;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Consumer " + this.getName() + " received >> " + bf.get());
        }
    }
}
