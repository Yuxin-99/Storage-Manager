package ui.Panel;

import Model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SearchPanel extends JPanel{
    private static int WIDTH = 800;
    private static int HEIGHT = 660;
    private Dimension d = new Dimension(360,150);
    private Manager m;

    private JFrame jFrame;
    private JPanel p1;
    private JButton back;
    private JTextArea textArea;
    private Font f;

    public SearchPanel(JFrame j, Manager m){
        jFrame = j;
        p1 = new JPanel();
        textArea = new JTextArea();
        f = new Font(Font.SANS_SERIF, Font.ITALIC, 28);

        p1.setLayout(new BorderLayout());
        p1.setBackground(new Color(255,204,204));
        p1.setSize(WIDTH,HEIGHT);

        back = new JButton("Back");
        back.setToolTipText("Back to the main panel");
        back.setMnemonic(KeyEvent.VK_D);
        back.setPreferredSize(d);
        back.setHorizontalTextPosition(SwingConstants.CENTER);
        back.setVerticalTextPosition(SwingConstants.CENTER);

        textArea.setBackground(new Color(255,204,204));
        textArea.setFont(f);
        textArea.setText("Your whole storage");


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
