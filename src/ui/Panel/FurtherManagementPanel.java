package ui.Panel;

import Model.IndividualStorage;
import Model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FurtherManagementPanel{
    private static int WIDTH = 800;
    private static int HEIGHT = 666;
    private Manager m;

    private JFrame jFrame;
    private JPanel p1;
    private JButton back;
    private JButton manage;
    private JTextField entry;
    private Font f;
    private JLabel l;

    public FurtherManagementPanel(JFrame j, Manager manager){
        jFrame = j;
        p1 = new JPanel();
        m = manager;
        f = new Font(Font.SERIF, Font.BOLD, 28);

        p1.setBackground(new Color(255,204,204));
        p1.setSize(WIDTH,HEIGHT);

        manage = createButton("Manage","Click to enter this storage");
        back = createButton("Back","Back to the main panel");

        entry = new JTextField(30);
        entry.setFont(f);
        l = new JLabel();
        l.setText("Enter the name of the storage you want to manage:");

        p1.add(l);
        p1.add(entry);
        p1.add(manage);
        p1.add(back);

        manage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = entry.getText();
                IndividualStorage currentI = manager.getAvailableStorage().get(name);
                jFrame.remove(p1);
                jFrame.setContentPane(new IndividualPanel(jFrame, m, currentI).getJPanel());
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

    private JButton createButton(String st, String tip){
        JButton j = new JButton(st);
        j.setToolTipText(tip);
        j.setMnemonic(KeyEvent.VK_D);
        j.setHorizontalTextPosition(SwingConstants.CENTER);
        j.setVerticalTextPosition(SwingConstants.BOTTOM);
        j.setFont(new Font(Font.DIALOG,Font.PLAIN,28));
        return j;
    }

    public JPanel getJPanel() {
        return p1;
    }
}
