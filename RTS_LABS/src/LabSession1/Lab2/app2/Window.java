package LabSession1.Lab2.app2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class Window extends JFrame implements Observer {
    ArrayList<JProgressBar> bars = new ArrayList<JProgressBar>();
    public Window(int nrThreads) {
        setLayout(null);
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nrThreads);
        this.setVisible(true);
    }

    public void init(int n) {
        for (int i = 0; i < n; i++) {
            JProgressBar pb = new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50, (i + 1) * 30, 350, 20);
            this.add(pb);
            this.bars.add(pb);
        }
    }
    public void update(Observable o, Object arg) {
        int id = ((Fir)o).getId();
        int c = ((Fir)o).getC();
        bars.get(id).setValue(c);

    }
}