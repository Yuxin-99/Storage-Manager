package ui.Panel;

import Model.IndividualStorage;
import Model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class IndividualPanel{
    private static int WIDTH = 800;
    private static int HEIGHT = 660;
    private Manager m;
    private IndividualStorage i;

    private JFrame jFrame;
    private JPanel p1;
    private JPanel p2;
    private JButton back;
    private JButton add;
    private JButton delete;
    private JButton show;
    private JButton capacity;
    private JTextField entry;
    private JTextArea textArea;
    private JLabel l;

    private Font f1,f2;

    public IndividualPanel(JFrame j, Manager manager, IndividualStorage individualStorage){
        jFrame = j;
        p1 = new JPanel();
        p2 = new JPanel();
        l = new JLabel();
        m = manager;
        i = individualStorage;
        textArea = new JTextArea();
        entry = new JTextField();
        f1 = new Font(Font.MONOSPACED, Font.BOLD, 28);
        f2 = new Font(Font.DIALOG,Font.PLAIN,21);

        p1.setBackground(new Color(255,204,204));
        p1.setSize(WIDTH,HEIGHT);
        p2.setBackground(Color.WHITE);
        p2.setSize(WIDTH,HEIGHT/2);

        add = createButton("Add","Click to add this",20,450,45,35);
        delete = createButton("Delete","Click to discard a stock",20,500,45,35);
        show = createButton("Show","Click to view this storage",20,550,45,35);
        capacity = createButton("Capacity","Click to set a max capacity for this storage",20,600,45,35);
        back = createButton("Back", "Back to the main panel",755,640,35,20);


        textArea.setBackground(new Color(255,204,204));
        textArea.setFont(f1);
        textArea.setText("Your whole storage");

        l.setText("Enter here");
        entry.setFont(f2);
        entry.add(l);
        entry.setColumns(10);

        p1.add(p2);
        p1.add(back);
        p2.add(textArea);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p1);
                jFrame.setContentPane(new MainPanel(jFrame, m).getJPanel());
                jFrame.setVisible(true);
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p1);
                jFrame.setContentPane(new MainPanel(jFrame, m).getJPanel());
                jFrame.setVisible(true);
            }
        });

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p1);
                jFrame.setContentPane(new MainPanel(jFrame, m).getJPanel());
                jFrame.setVisible(true);
            }
        });

        capacity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p1);
                jFrame.setContentPane(new MainPanel(jFrame, m).getJPanel());
                jFrame.setVisible(true);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p1);
                jFrame.setContentPane(new MainPanel(jFrame, m).getJPanel());
                jFrame.setVisible(true);
            }
        });
    }

    public JPanel getJPanel() {
        return p1;
    }

    private JButton createButton(String st, String tip, int x, int y, int w, int h){
        JButton j = new JButton(st);
        j.setMnemonic(KeyEvent.VK_D);
        j.setToolTipText(tip);
        j.setBounds(x,y,w,h);
        j.setHorizontalTextPosition(SwingConstants.CENTER);
        j.setVerticalTextPosition(SwingConstants.CENTER);
        return j;
    }
}
