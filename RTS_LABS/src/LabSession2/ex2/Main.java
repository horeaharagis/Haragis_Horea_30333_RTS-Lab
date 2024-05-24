package LabSession2.ex2;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
