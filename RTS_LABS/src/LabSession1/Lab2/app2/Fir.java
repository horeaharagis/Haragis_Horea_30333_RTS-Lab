package LabSession1.Lab2.app2;

import java.util.Observable;

public class Fir extends Observable implements Runnable {
    Thread t;
    int id;
    int processorLoad;
    int c = 0;

    public int getC() {
        return c;
    }

    public int getId() {
        return id;
    }

    public Fir(int id, int processorLoad) {
        this.id = id;
        this.processorLoad = processorLoad;
    }

    public void startThread() {
        if (this.t == null) {
            this.t = new Thread(this);
            this.t.start();
        }
    }

    @Override
    public void run() {
        this.c = 0;
        while (c < 1000) {
            for (int j = 0; j < this.processorLoad; j++) {
                j++;
            }
            c++;
            this.setChanged();
            this.notifyObservers();
        }
    }
}