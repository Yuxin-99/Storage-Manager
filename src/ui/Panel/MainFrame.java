package ui.Panel;

import Model.Manager;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static int WIDTH = 800;
    private static int HEIGHT = 660;
    private JFrame j;
    private Manager m;

    public MainFrame(Manager m){
        this.m = m;
        j = new JFrame("Welcome to your storage manager!");
        j.setBackground(Color.PINK);
        j.setSize(WIDTH,HEIGHT);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setContentPane(new MainPanel(j,m).getJPanel());
        j.setVisible(true);
    }


}
