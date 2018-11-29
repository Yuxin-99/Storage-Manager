package ui.Panel;

import Model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SearchPanel{
    private static int WIDTH = 800;
    private static int HEIGHT = 660;
    private Dimension d = new Dimension(360,150);
    private Manager m;

    private JFrame jFrame;
    private JPanel p0;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JButton search;
    private JButton back;
    private JTextArea textArea;
    private JTextField entry;
    private Font f1,f2;
    private JLabel l;

    public SearchPanel(JFrame j, Manager m){
        jFrame = j;
        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        ImageIcon icon = createImageIcon("Images/continue.gif");
        textArea = new JTextArea();
        entry = new JTextField(21);
        l = new JLabel("Enter the name of the item:");
        f1 = new Font(Font.SERIF, Font.BOLD, 28);
        f2 = new Font(Font.DIALOG,Font.PLAIN,21);

        p0.setLayout(new BoxLayout(p0,BoxLayout.Y_AXIS));
        p0.setBackground(new Color(255,204,204));
        p0.setSize(WIDTH,HEIGHT);
        p1.setBackground(new Color(30,192,255));
        p2.setBackground(new Color(165,223,249));
        p3.setBackground(new Color(214,236,250));

        search = new JButton("Search");
        search.setToolTipText("Click to see the position of this item");
        search.setMnemonic(KeyEvent.VK_D);
        search.setPreferredSize(d);
        search.setHorizontalTextPosition(SwingConstants.CENTER);
        search.setVerticalTextPosition(SwingConstants.CENTER);
        search.setFont(new Font(Font.DIALOG,Font.BOLD,21));
        search.setForeground(new Color(255,127,143));
        back = new JButton("Back",icon);
        back.setToolTipText("Back to the main panel");
        back.setMnemonic(KeyEvent.VK_D);
        back.setPreferredSize(d);
        back.setHorizontalTextPosition(SwingConstants.LEADING);
        back.setVerticalTextPosition(SwingConstants.CENTER);
        back.setFont(new Font(Font.DIALOG,Font.BOLD,21));
        back.setForeground(new Color(255,127,143));

        textArea.setBackground(new Color(30,192,255));
        textArea.setFont(f1);
        textArea.setEditable(false);
        entry.setFont(f2);

        p1.add(textArea);
        p2.add(l);
        p2.add(entry);
        p3.add(search);
        p3.add(back);
        p0.add(p1);
        p0.add(p2);
        p0.add(p3);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = entry.getText();
                String pos = m.searchItem(item);
                String print = "This item is in: " + pos;
                textArea.setText(print);
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p0);
                jFrame.setContentPane(new MainPanel(jFrame, m).getJPanel());
                jFrame.setVisible(true);
            }
        });
    }

    public JPanel getJPanel() {
        return p0;
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
