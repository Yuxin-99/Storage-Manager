package ui.Panel;

import Model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class DisplayPanel {
    private static int WIDTH = 800;
    private static int HEIGHT = 666;
    private Manager m;

    private JFrame jFrame;
    private JPanel p1;
    private JButton back;
    private JTextArea textArea;
    private Font f;

    public DisplayPanel(JFrame j, Manager manager){
        jFrame = j;
        p1 = new JPanel();
        m = manager;
        textArea = new JTextArea();
        f = new Font(Font.MONOSPACED, Font.BOLD, 28);
        String output = m.displayStorage();

        p1.setLayout(new BorderLayout());
        p1.setBackground(new Color(255,204,204));
        p1.setSize(WIDTH,HEIGHT);

        back = new JButton("Back");
        back.setToolTipText("Back to the main panel");
        back.setMnemonic(KeyEvent.VK_D);
        back.setHorizontalTextPosition(SwingConstants.CENTER);
        back.setVerticalTextPosition(SwingConstants.CENTER);

        textArea.setBackground(new Color(255,204,204));
        textArea.setFont(f);
        textArea.setText(output);

        p1.add(back,BorderLayout.PAGE_END);
        p1.add(textArea,BorderLayout.PAGE_START);
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
