package LabSession2.ex1;

public class Main {

    private static boolean stopThread = false;
    public static void main(String[] args) {
        FileService service = new FileService("messages.txt");
        RThread reader = new RThread(service);
        WThread writer = new WThread(service);

        reader.start();
        writer.start();
    }

    public static boolean isStopThread() {
        return stopThread;
    }
}
