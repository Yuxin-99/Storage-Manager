package ui.Panel;

import ui.Panel.Icons.Icon;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class MainPanel extends JFrame {
    private List<ui.Panel.Icons.Icon> icons;
    private static int WIDTH = 800;
    private static int HEIGHT = 666;

    public MainPanel(){
        super("Welcome to your storage manager!");
        icons = new LinkedList<>();
        setBackground(Color.PINK);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void addIcon(Icon e){
        icons.add(e);
    }
}
