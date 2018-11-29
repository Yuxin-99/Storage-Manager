package ui.Panel;

import Exceptions.fullStorage;
import Exceptions.invalidLimit;
import Exceptions.noneExist;
import Model.IndividualStorage;
import Model.Manager;
import Model.OrdinaryItem;

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
    private JPanel p0,p2,p3;
    private JButton back, add, delete, show, capacity;
    private JTextField entry;
    private JTextArea textArea;
    private JScrollPane scroll;
    private JLabel l;

    private Font f1,f2;

    public IndividualPanel(JFrame j, Manager manager, IndividualStorage individualStorage){
        jFrame = j;
        p0 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        l = new JLabel();
        m = manager;
        i = individualStorage;
        textArea = new JTextArea();
        entry = new JTextField(36);
        f1 = new Font(Font.SERIF, Font.BOLD, 28);
        f2 = new Font(Font.DIALOG,Font.PLAIN,21);

        p0.setBackground(new Color(255,204,204));
        p0.setSize(WIDTH,HEIGHT);
        p0.setLayout(new BoxLayout(p0, BoxLayout.Y_AXIS));
        p2.setBackground(new Color(255,204,204));
        p3.setBackground(new Color(250,230,227));

        add = createButton("Add","Click to add this",20,0,45,35);
        delete = createButton("Delete","Click to discard a stock",20,50,45,35);
        show = createButton("Show","Click to view this storage",20,100,45,35);
        capacity = createButton("Capacity","Click to set a max capacity for this storage",20,150,45,35);
        back = createButton("Back", "Back to the main panel",755,190,35,20);

        textArea = new JTextArea();
        textArea.setBackground(new Color(255,204,204));
        textArea.setFont(f1);
        textArea.setText(i.getName());
        textArea.setEditable(false);
        textArea.setRows(6);
        scroll = new JScrollPane(textArea);

        l.setText("Enter here before you continue");
        entry.setFont(f2);

        p2.add(l);
        p2.add(entry);
        p3.add(add);
        p3.add(delete);
        p3.add(show);
        p3.add(capacity);
        p3.add(back);
        p0.add(scroll);
        p0.add(p2);
        p0.add(p3);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = entry.getText();
                try {
                    i.addItem(new OrdinaryItem(name));
                } catch (Exceptions.fullStorage fullStorage) {
                    fullStorage.printStackTrace();
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = entry.getText();
                try {
                    i.moveItem(name);
                } catch (Exceptions.noneExist noneExist) {
                    noneExist.printStackTrace();
                }
            }
        });

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = i.showStock();
                textArea.setText(res);
            }
        });

        capacity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer max = Integer.valueOf(entry.getText());
                try {
                    i.setMaxCapacity(max);
                } catch (Exceptions.invalidLimit invalidLimit) {
                    invalidLimit.printStackTrace();
                }
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

    private JButton createButton(String st, String tip, int x, int y, int w, int h){
        ImageIcon icon = createImageIcon("Images/continue.gif");
        JButton j = new JButton(st);
        j.setMnemonic(KeyEvent.VK_D);
        j.setToolTipText(tip);
        j.setBounds(x,y,w,h);
        j.setHorizontalTextPosition(SwingConstants.CENTER);
        j.setVerticalTextPosition(SwingConstants.CENTER);
        j.setForeground(new Color(147,208,255));
        j.setFont(new Font(Font.DIALOG,Font.BOLD,21));
        if (st.equals("Back")){j.setIcon(icon);
        j.setHorizontalTextPosition(SwingConstants.LEADING);}
        return j;
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
