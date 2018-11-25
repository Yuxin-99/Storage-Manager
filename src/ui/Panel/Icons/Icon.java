package ui.Panel.Icons;

import ui.StorageManagerDisplay;

import javax.swing.*;
import java.awt.*;

public abstract class Icon {
    protected JButton button;
    protected StorageManagerDisplay main;

    public Icon(StorageManagerDisplay main, JComponent parent){
        this.main = main;
        createButton(parent, main.getManager().getAvailableStorage().toString());
        addToParent(parent);
        addListener();
    }

    protected abstract void addListener();

    protected void addToParent(JComponent parent){
        parent.add(button);
    }

    protected void createButton(JComponent parent, String text){
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 24);
        button.setPreferredSize(new Dimension(main.getWidth()/2, main.getHeight()/2));
        button.setFont(font);

        addToParent(parent);
    }

    protected ImageIcon createImageIcon(String path){
        java.net.URL imgURL = Icon.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
