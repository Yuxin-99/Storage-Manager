package ui.Panel.Icons;

import ui.StorageManagerDisplay;

import javax.swing.*;

public class ItemIcon extends Icon{

    public ItemIcon(StorageManagerDisplay main, JComponent parent) {
        super(main, parent);
    }

    protected void createButton(JComponent parent, String text) {
        ImageIcon storageImage = createImageIcon("Images/Item.gif");
        button = new JButton(text,storageImage);
        super.createButton(parent,text);
    }

    @Override
    protected void addListener() {

    }
}
