package ui;

import Model.Storage;
import Model.individualStorage;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static Storage allStorage;

    public static void main(String[] args){
        String option = "";
        System.out.println("Welcome to your storage information! What would you like to do? [1]show all items in storage, [2]add a storage, [3]add an item, [4]remove an item to a new place, [5]discard an item. Please choose one number as your option.");
        option = scanner.nextLine();
        if (option.equals("1")){
            System.out.println("You choose to " + "show all items in storage.");
            allStorage.displayAllItems();
        }

        else if (option.equals("2")){
            System.out.println("You choose to " + "add a storage.");
            allStorage.addNew();
        }

        else if (option.equals("3")){
            String chooseStorage = "";
            System.out.println("You choose to " + "add an item.");
            System.out.println("Where would you like to store this item?");
            chooseStorage = scanner.nextLine();
            allStorage.StorageToStore(chooseStorage);
        }

        else if (option.equals("4")){
            System.out.println("You choose to " + "remove an item to a new place.");
        }

        else if (option.equals("5")){
            System.out.println("You choose to " + "discard an item.");
        }
    }
}
