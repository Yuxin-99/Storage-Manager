package ui;

import Model.Manager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Scanner;

import Exceptions.noneExist;
import Model.DataNotifier;
import Model.OrdinaryItem;

import javax.swing.*;

public class StorageManagerDisplay extends JFrame {
    static Scanner scanner = new Scanner(System.in);
    private static int WIDTH = 888;
    private static int HEIGHT = 666;
    public static Manager manager;

    public StorageManagerDisplay() {
        super("StorageIcon Manager");

    }

    public Manager getManager() {
        return manager;
    }

    public static void main(String[] args){
        manager = new Manager();
        String option = "";
        manager.addNew("bookshelf");
        manager.addNew("plastic case");
        manager.addNew("wardrobe");

        manager.getAvailableStorage().get("bookshelf").getStocks().add(new OrdinaryItem("dictionary"));
        manager.getAvailableStorage().get("bookshelf").getStocks().add(new OrdinaryItem("laptop"));
        manager.getAvailableStorage().get("plastic case").getStocks().add(new OrdinaryItem("lipstick"));
        manager.getAvailableStorage().get("plastic case").getStocks().add(new OrdinaryItem("scarf"));
        manager.getAvailableStorage().get("wardrobe").getStocks().add(new OrdinaryItem("coats"));

        while (true){
            System.out.println("Welcome to your storage manager! What would you like to do?");
            System.out.println("[1]display the whole storage, [2]add a storage, [3]manage one storage, [4]move an item to a new place, [5]look for an item, [6]quit.");
            System.out.println("Please choose one number as your option.");
            option = scanner.nextLine();
            if (option.equals("1")) {
                manager.displayStorage();
            } else if (option.equals("2")) {
                System.out.println("Please enter the name of the new storage.");
                String stName = scanner.nextLine();
                manager.addNew(stName);
            } else if (option.equals("3")) {
                try {
                    manager.manageOne();
                } catch (noneExist e) {
                    System.out.println("Sorry. The storage you entered doesn't exist.");
                }
            } else if (option.equals("4")) {
                try {
                    manager.move();
                } catch (noneExist e) {
                    System.out.println("Sorry. The storage (item) you entered doesn't exist.");
                }
            } else if (option.equals("5")){
                manager.searchItem();
            } else if (option.equals("6")) {
                break;
            } else {
                System.out.println("Try again");
            }
        }
    }

}
