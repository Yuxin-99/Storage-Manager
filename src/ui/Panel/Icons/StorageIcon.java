package ui.Panel.Icons;

import ui.Panel.Icons.Icon;
import ui.StorageManagerDisplay;

import javax.swing.*;
import java.awt.*;

public class StorageIcon extends Icon {
    public StorageIcon(StorageManagerDisplay main, JComponent parent) {
        super(main, parent);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void createButton(JComponent parent, String text) {
        ImageIcon storageImage = createImageIcon("Images/StorageIcon.gif");
        button = new JButton(text,storageImage);
        super.createButton(parent,text);
    }
}
