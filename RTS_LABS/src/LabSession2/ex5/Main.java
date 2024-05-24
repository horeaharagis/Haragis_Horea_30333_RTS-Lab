package LabSession2.ex5;

public class Main {
    public static void main(String[] args) {
        ReadThread readThread = new ReadThread();
        WriteThread writeThread = new WriteThread();

        try {
            readThread.connect(writeThread.getPipe());
            readThread.start();
            writeThread.start();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
