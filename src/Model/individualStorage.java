package Model;

import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.consoleException;
import Exceptions.noneExist;
import Exceptions.fullStorage;

public class individualStorage {
    Scanner scanner = new Scanner(System.in);
    private String name;
    private ArrayList<Item> Items;
    private Integer maxCapacity;

    public individualStorage(String name){
        Items = new ArrayList<>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Item> getItems(){
        return Items;
    }

    public void setMaxCapacity(int maximum){
        maxCapacity = maximum;
    }

    public void doSomething(individualStorage i) throws consoleException, noneExist {
        System.out.println("Please select the option you want to do.");
        System.out.println("[1]display this storage, [2]show details of item, [3]Store an item to this storage, [4]Discard an item from this storage.");
        String command = scanner.nextLine();
        if (command.equals("1")){
            i.display();
        } else if (command.equals("2")){
            System.out.println("Please enter the name of the item.");
            String itName = scanner.nextLine();
            boolean flag = false;
            for (Item it: Items){
                if (it.getName().equals(itName)){
                    it.showItem();
                    flag = !flag;
                    break;
                }
            } if(!flag){throw new noneExist();}
        } else if (command.equals("3")){
            System.out.println("Does this item has a limited lifetime? Reply yes or no.");
            String type = scanner.nextLine();
            System.out.println("Please enter the name of the item you would like to store.");
            String itName = scanner.nextLine();
            if (type.equals("yes")){
                i.storeItem0(itName);
            }
            else if (type.equals("no")){
                i.storeItem1(itName);
            }
        } else if (command.equals("4")){
            System.out.println("Please enter the name of the item you would like to discard.");
            String itName = scanner.nextLine();
            i.moveItem(itName);
        } else {
            throw new consoleException();
        }
    }

    //EFFECTS: show all items in this individual storage
    public void display(){
        String res = "";
        for (Item item : Items) {
            res = res + item.name + "  ";
        }
        System.out.println("[" + res + "]" + ";");
    }

    //REQUIRES: this is an new item which is not in the list before
    //MODIFIES: this.Items
    //EFFECTS: add an Item with limited lifetime into the Items of this individualStorage
    public void storeItem0(String nm){
        limitedUse newItem = new limitedUse(nm);
        Items.add(newItem);
        try {
            verifyStore(newItem);
        } catch (Exceptions.fullStorage fullStorage) {
            System.out.println("Sorry, this storage is full.");
        }
        System.out.println("How long is its lifetime? (days)");
        int lim = Integer.parseInt(scanner.nextLine());
        newItem.setLimitation(lim);
    }

    //REQUIRES: this is an new item which is not in the list before
    //MODIFIES: this.Items
    //EFFECTS: add an ordinaryItem into the Items of this individualStorage
    public void storeItem1(String nm){
        Item newItem = new ordinaryItem(nm);
        Items.add(newItem);
        try {
            verifyStore(newItem);
        } catch (Exceptions.fullStorage fullStorage) {
            System.out.println("Sorry, this storage is full.");
        }
    }

    //EFFECTS: verify an item is added to the list of items of this storage or not
    public boolean verifyStore(Item i) throws fullStorage {
        if (maxCapacity == null){
            return Items.contains(i);
        }
        else {
            if (Items.size() > maxCapacity){
                Items.remove(i);
                throw new fullStorage();
            }
            else {
                return Items.contains(i);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: add an item which is moved from another individual storage
    public void addItem(ordinaryItem i){
        Items.add(i);
        try {
            verifyStore(i);
        } catch (Exceptions.fullStorage fullStorage) {
            System.out.println("Sorry, this storage is full.");
        }
    }

    public void moveItem(String nm){}

    //MODIFIES: this.Items
    //EFFECTS: add an Item into the Items of this individualStorage
    public void removeItem(ordinaryItem i) throws noneExist {
        boolean flag = false;
        for (Item S : this.Items){
            if (i.name.equals(S.name)){
                Items.remove(S);
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new noneExist();
        }
    }
}
