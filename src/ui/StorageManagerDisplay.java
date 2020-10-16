package ui;

import Model.Manager;
import Model.OrdinaryItem;
import ui.Panel.MainFrame;

import java.util.Scanner;

public class StorageManagerDisplay {
    static Scanner scanner = new Scanner(System.in);
    public static Manager manager;
    private static MainFrame c;


    public Manager getManager() {
        return manager;
    }

    public StorageManagerDisplay(){

        manager = new Manager();
        manager.addNew("bookshelf");
        manager.addNew("plastic case");
        manager.addNew("wardrobe");

        manager.getAvailableStorage().get("bookshelf").getStocks().add(new OrdinaryItem("dictionary"));
        manager.getAvailableStorage().get("bookshelf").getStocks().add(new OrdinaryItem("laptop"));
        manager.getAvailableStorage().get("plastic case").getStocks().add(new OrdinaryItem("lipstick"));
        manager.getAvailableStorage().get("plastic case").getStocks().add(new OrdinaryItem("scarf"));
        manager.getAvailableStorage().get("wardrobe").getStocks().add(new OrdinaryItem("coats"));

        c = new MainFrame(manager);
    }

    public static void main(String[] args){
        new StorageManagerDisplay();
    }

}
