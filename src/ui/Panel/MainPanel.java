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

        b1 = new JButton("Display");
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setBounds(260,0,300,150);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b1.setVerticalTextPosition(SwingConstants.TOP);

        b2 = new JButton("Add");
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setBounds(260,160,300,150);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setVerticalTextPosition(SwingConstants.CENTER);

        b3 = new JButton("Further Management");
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setBounds(260,320,300,150);
        b3.setHorizontalTextPosition(SwingConstants.CENTER);
        b3.setVerticalTextPosition(SwingConstants.CENTER);

        b4 = new JButton("Search");
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b4.setMnemonic(KeyEvent.VK_E);
        b4.setBounds(260,480,300,150);
        b4.setHorizontalTextPosition(SwingConstants.CENTER);
        b4.setVerticalTextPosition(SwingConstants.BOTTOM);

        b1.setToolTipText("Click this button to view the whole storage.");
        b2.setToolTipText("Click this button to add a new storage.");
        b3.setToolTipText("Click this button to manage one storage.");
        b4.setToolTipText("Click this button to look for an item.");

        //Add Components to this container, using the default FlowLayout.
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        jPanel.add(b4);

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public JPanel getJPanel() {
        return jPanel;
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
