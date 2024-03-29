package LabSession2.ex1;

import LabSession2.ex1.FileService;
import LabSession2.ex1.Main;

public class WThread extends Thread{

    FileService service;

    public WThread(FileService service) {

        this.service = service;

    }

    public void run(){

        while(!Main.isStopThreads()){

            String msg=String.valueOf(Math.round(Math.random()*100));

            service.write(msg);

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}
