package ui;

import Model.Storage;
import Model.individualStorage;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static Storage allStorage;

    public static void main(String[] args){
        String option = "";
        allStorage = new Storage();
        allStorage.addNew("bookshelf");
        allStorage.addNew("plastic case");
        allStorage.addNew("wardrobe");
        allStorage.availableStorage.get(0).setMaxCapacity(6);
        allStorage.availableStorage.get(1).setMaxCapacity(3);
        allStorage.availableStorage.get(2).setMaxCapacity(10);

        allStorage.availableStorage.get(0).storeItem("dictionary");
        allStorage.availableStorage.get(0).storeItem("laptop");
        allStorage.availableStorage.get(1).storeItem("lipstick");
        allStorage.availableStorage.get(1).storeItem("scarf");
        allStorage.availableStorage.get(2).storeItem("coats");

        while (true){
            System.out.println("Welcome to your storage manager! What would you like to do? [1]display the whole storage, [2]add a storage, [3]add an item, [4]move an item to a new place, [5]discard an item, [6]quit. Please choose one number as your option.");
            option = scanner.nextLine();
            if (option.equals("1")){
                allStorage.displayStorage();
            }

            else if (option.equals("2")){
                System.out.println("You choose to " + "add a storage.");
                System.out.println("Please enter the name of the new storage.");
                String stName = scanner.nextLine();
                allStorage.addNew(stName);
            }

            else if (option.equals("3")){
                allStorage.StorageToStore();
            }

            else if (option.equals("4")){
                allStorage.move();
            }

            else if (option.equals("5")){
                allStorage.delete();
            }

            else if (option.equals("6")){
                break;
            }
        }
    }
}
