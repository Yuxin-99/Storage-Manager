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
//
//        while (true){
//            System.out.println("Welcome to your storage manager! What would you like to do?");
//            System.out.println("[1]display the whole storage, [2]add a storage, [3]manage one storage, [4]move an item to a new place, [5]look for an item, [6]quit.");
//            System.out.println("Please choose one number as your option.");
//            option = scanner.nextLine();
//            if (option.equals("1")) {
//                manager.displayStorage();
//            } else if (option.equals("2")) {
//                System.out.println("Please enter the name of the new storage.");
//                String stName = scanner.nextLine();
//                manager.addNew(stName);
//            } else if (option.equals("3")) {
//                try {
//                    manager.manageOne();
//                } catch (noneExist e) {
//                    System.out.println("Sorry. The storage you entered doesn't exist.");
//                }
//            } else if (option.equals("4")) {
//                try {
//                    manager.move();
//                } catch (noneExist e) {
//                    System.out.println("Sorry. The storage (item) you entered doesn't exist.");
//                }
//            } else if (option.equals("5")){
//                manager.searchItem();
//            } else if (option.equals("6")) {
//                break;
//            } else {
//                System.out.println("Try again");
//            }
//        }
    }

    public static void main(String[] args){
        new StorageManagerDisplay();
    }

}
