package ui.Panel;

import Model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AddStoragePanel implements ActionListener{
    private static int WIDTH = 800;
    private static int HEIGHT = 660;
    private Manager m;

    private JFrame j;
    private JPanel p1;
    private JButton back;
    private JButton add;
    private JTextField entry;
    private JLabel l;

    public AddStoragePanel(JFrame jFrame, Manager manager){
        p1 = new JPanel();
        p1.setBackground(new Color(255,204,204));
        p1.setSize(WIDTH,HEIGHT);
        j = jFrame;
        m = manager;

        add = new JButton("Add");
        add.setToolTipText("Click to add this storage");
        add.setBounds(225, 420, 45,28);
        back.setMnemonic(KeyEvent.VK_D);
        back.setHorizontalTextPosition(SwingConstants.CENTER);
        back.setVerticalTextPosition(SwingConstants.BOTTOM);

        back = new JButton("Back");
        back.setToolTipText("Back to the main panel");
        back.setMnemonic(KeyEvent.VK_D);
        back.setBounds(290,420,45,28);
        back.setHorizontalTextPosition(SwingConstants.CENTER);
        back.setVerticalTextPosition(SwingConstants.BOTTOM);

        entry = new JTextField(25);
        entry.setFont(new Font(Font.DIALOG,Font.ITALIC,32));
        l = new JLabel();
        l.setText("Enter the name of the new storage");
        l.setFont(new Font(Font.DIALOG,Font.PLAIN,21));
        entry.add(l);

        p1.add(entry);
        p1.add(add);
        p1.add(back);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = entry.getText();
                m.addNew(name);
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

    public JPanel getJPanel(){
        return p1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){

        } else {
            String name = entry.getText();

        }
    }
}
