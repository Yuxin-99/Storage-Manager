package ui.Panel;

import Model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AddStoragePanel{
    private static int WIDTH = 800;
    private static int HEIGHT = 660;
    private Manager m;

    private JFrame j;
    private JPanel p1, p2, p3;
    private JButton back;
    private JButton add;
    private JTextField entry;
    private JLabel l;

    public AddStoragePanel(JFrame jFrame, Manager manager){
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setBackground(new Color(255,204,204));
        p2.setBackground(new Color(255,204,204));
        p3.setBackground(new Color(255,204,204));
        p1.setSize(WIDTH,HEIGHT);
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));

        j = jFrame;
        m = manager;

        add = createButton("Add","Click to add this storage",225,420,45,28);
        back = createButton("Back","Back to the main panel",290,420,45,28);

        entry = new JTextField(25);
        entry.setFont(new Font(Font.SERIF,Font.PLAIN,32));
        l = new JLabel();
        l.setText("Enter the name of the new storage:");
        l.setFont(new Font(Font.DIALOG,Font.PLAIN,18));

        p2.add(l);
        p2.add(entry);
        p3.add(add);
        p3.add(back);
        p1.add(p2);
        p1.add(p3);
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

    private JButton createButton(String st, String tip, int x, int y, int w, int h){
        ImageIcon icon = createImageIcon("Images/continue.gif");
        JButton j = new JButton(st);
        j.setToolTipText(tip);
        j.setBounds(x,y,w,h);
        j.setMnemonic(KeyEvent.VK_D);
        j.setHorizontalTextPosition(SwingConstants.CENTER);
        j.setVerticalTextPosition(SwingConstants.CENTER);
        j.setFont(new Font(Font.DIALOG,Font.PLAIN,28));
        j.setForeground(new Color(147,208,255));
        if (st.equals("Back")){j.setIcon(icon);
        j.setHorizontalTextPosition(SwingConstants.LEADING);}
        return j;
    }

    public JPanel getJPanel(){
        return p1;
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
}
