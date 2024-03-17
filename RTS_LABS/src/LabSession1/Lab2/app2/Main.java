package LabSession1.Lab2.app2;

public class Main {
    static final int noOfThreads = 6;
    static final int processorLoad = 100000000;

    public static void main(String[] args) {
        StartC startClas = new StartC();
        startClas.startProgram();
    }
}