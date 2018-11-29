package ui.Panel;

import Model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainPanel implements ActionListener {
    private static int WIDTH = 800;
    private static int HEIGHT = 660;
    private Manager m;

    private JPanel jPanel;
    private JFrame jFrame;
    private JButton b1, b2, b3, b4;

    public MainPanel(JFrame jFrame, Manager manager){
        jPanel = new JPanel();
        this.jFrame = jFrame;
        m = manager;

        jPanel.setBackground(new Color(255,204,204));
        jPanel.setSize(WIDTH,HEIGHT);
        jPanel.setLayout(null);

        b1 = createButton("Display","Click this button to view the whole storage.",260,8,300,150);
        b2 = createButton("Add","Click this button to add a new storage.",260,168,300,150);
        b3 = createButton("Further Management","Click this button to manage one storage.",260,328,300,150);
        b4 = createButton("Search","Click this button to look for an item.",260,488,300,150);

        //Add Components to this container, using the default FlowLayout.
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        jPanel.add(b4);
    }

    private JButton createButton(String st, String tip, int x, int y, int w, int h){
        ImageIcon icon = createImageIcon("Images/continue.gif");
        JButton j = new JButton(st,icon);
        j.setToolTipText(tip);
        j.setBounds(x,y,w,h);
        j.setMnemonic(KeyEvent.VK_D);
        j.setHorizontalTextPosition(SwingConstants.LEADING);
        j.setVerticalTextPosition(SwingConstants.CENTER);
        j.setFont(new Font(Font.SERIF,Font.PLAIN,28));
        j.addActionListener(this);
        return j;
    }

    public JPanel getJPanel() {
        return jPanel;
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MainPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            jFrame.remove(jPanel);
            jFrame.setContentPane(new DisplayPanel(jFrame, m).getJPanel());
        } else if (e.getSource() == b2){
            jFrame.remove(jPanel);
            jFrame.setContentPane(new AddStoragePanel(jFrame, m).getJPanel());
        } else if (e.getSource() == b3){
            jFrame.remove(jPanel);
            jFrame.setContentPane(new FurtherManagementPanel(jFrame, m).getJPanel());
        } else if (e.getSource() == b4){
            jFrame.remove(jPanel);
            jFrame.setContentPane(new SearchPanel(jFrame, m).getJPanel());
        }
    }
}
