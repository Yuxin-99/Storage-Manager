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
    private Dimension d = new Dimension(360,150);
    private Manager m;

    private JFrame jFrame;
    private JPanel p1;
    private JButton back;
    private JButton manage;
    private JTextArea textArea;
    private Font f;
    private JLabel l;

    public FurtherManagementPanel(JFrame j, Manager manager){
        jFrame = j;
        p1 = new JPanel();
        m = manager;
        textArea = new JTextArea();
        l.setText("Enter the name of the storage you want to manage");
        textArea.add(l);
        f = new Font(Font.MONOSPACED, Font.BOLD, 28);

        p1.setLayout(new BorderLayout());
        p1.setBackground(new Color(255,204,204));
        p1.setSize(WIDTH,HEIGHT);

        manage = new JButton("Manage");
        manage.setToolTipText("Click to continue to enter this storage");
        manage.setMnemonic(KeyEvent.VK_D);
        manage.setHorizontalTextPosition(SwingConstants.CENTER);
        manage.setVerticalTextPosition(SwingConstants.CENTER);

        back = new JButton("Back");
        back.setToolTipText("Back to the main panel");
        back.setMnemonic(KeyEvent.VK_D);
        back.setHorizontalTextPosition(SwingConstants.CENTER);
        back.setVerticalTextPosition(SwingConstants.CENTER);

        textArea.setBackground(new Color(255,204,204));
        textArea.setFont(f);

        p1.add(back,BorderLayout.PAGE_END);
        p1.add(textArea,BorderLayout.PAGE_START);

        manage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textArea.getText();
                IndividualStorage currentI = manager.getAvailableStorage().get(new IndividualStorage(name));
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

    public JPanel getJPanel() {
        return p1;
    }
}
