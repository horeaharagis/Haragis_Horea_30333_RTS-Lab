package LabSession2.ex1;

import LabSession2.ex1.FileService;
import LabSession2.ex1.Main;

public class RThread extends Thread{

    FileService service;

    public RThread(FileService service) {

        this.service = service;

    }

    public void run(){

        while (!Main.isStopThreads()){

            try {

                String readMsg = service.read();

                System.out.println(readMsg);

                Thread.sleep(3000);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

}