package LabSession2.ex3;

public class JoinTestThread extends Thread {
    Thread t;
    String n;
    JoinTestThread(String n, Thread t){
        this.n = n;
        this.t=t;
    }
    public void run() {
        System.out.println("Thread "+n+" has entered the run() method");
        try {
            if (t != null)
                t.join();
            int number;
            if (n.equals("Thread 1")) {
                number = 50001;
            } else {
                number = 20001;
            }

            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    Main.totalSum += i;
                }
            }
            System.out.println("Thread " + n + " executed operation. Sum of divisors: " + Main.totalSum);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}