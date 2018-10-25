package ui;

import Model.Manager;

import java.io.IOException;
import java.util.Scanner;

import Exceptions.noneExist;

public class Main{
    static Scanner scanner = new Scanner(System.in);
    public static Manager manager;

    public static void main(String[] args) throws IOException{
        manager = new Manager();
        String option = "";
        manager.addNew("bookshelf");
        manager.addNew("plastic case");
        manager.addNew("wardrobe");
        manager.getAvailableStorage().get(0);
        manager.getAvailableStorage().get(1);
        manager.getAvailableStorage().get(2);

        manager.getAvailableStorage().get(0).storeItem1("dictionary");
        manager.getAvailableStorage().get(0).storeItem1("laptop");
        manager.getAvailableStorage().get(1).storeItem1("lipstick");
        manager.getAvailableStorage().get(1).storeItem1("scarf");
        manager.getAvailableStorage().get(2).storeItem1("coats");

        while (true){
            System.out.println("Welcome to your storage manager! What would you like to do?");
            System.out.println("[1]display the whole storage, [2]add a storage, [3]manage one storage, [4]move an item to a new place, [5]save the information, [6]load a file, [7]quit.");
            System.out.println("Please choose one number as your option.");
            option = scanner.nextLine();
            //Assume consoleException, checkInput throws consoleException
            // try { checkInput() } catch（ConsoleException e)
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
            } else if (option.equals("5")) {
                manager.save();
            } else if (option.equals("6")) {
                manager.load();
            } else if (option.equals("7")) {
                break;
            } else {
//                try {
//                    throw new consoleException();
//                } catch (consoleException e) {
//                    System.out.println("Sorry. I can't understand the option you entered.");
//                }
                System.out.println("Try again");
            }
        }
    }
}
