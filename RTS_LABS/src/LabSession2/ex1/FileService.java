package LabSession2.ex1;

import java.io.*;
import java.util.Date;

public class FileService {
    String fileName;
    BufferedReader in;
    PrintWriter out;

    public FileService(String fileName){
        this.fileName = fileName;

        try {
            this.out = new PrintWriter(new FileWriter(fileName, true));
            this.in = new BufferedReader(new FileReader(fileName));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public  void write(String msg) {
        synchronized (this){
            Date date = new Date(System.currentTimeMillis());
            this.out.println("Date: " + date);
            this.out.println("Message: " + msg);
            this.out.flush();
        }

        }



    public  String read() throws IOException {
        synchronized (this){
        String iterator;
        String last = "no message to read";
        while ((iterator = in.readLine()) != null){
            last = new Date(System.currentTimeMillis()) + " - " + iterator;
        }
        return last;
    }
    }
}
