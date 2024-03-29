package LabSession2.ex3;

public class Main {

    static int totalSum = 0;
    public static void main(String[] args){
        JoinTestThread w1 = new JoinTestThread("Thread 1",null);
        JoinTestThread w2 = new JoinTestThread("Thread 2",w1);
        w1.start();
        w2.start();

        // Display the total sum of divisors
        System.out.println("Total sum of divisors: " + totalSum);
    }

}