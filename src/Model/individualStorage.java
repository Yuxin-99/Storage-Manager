package Model;

import java.util.ArrayList;
import Model.Storage;
import java.util.Scanner;

public class individualStorage {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Item> Items;
    public String name;
    public Integer maxCapacity;

    public individualStorage(String name){
        Items = new ArrayList<>();
        this.name = name;
    }

    public void setMaxCapacity(int maximum){
        maxCapacity = maximum;
    }

    //EFFECTS: show all items in this individual storage
    public void display(){
        String res = "";
        for (Item item : Items) {
            res = res + item.name + "   ";
        }
        System.out.println("Items in this individual storage are:");
        System.out.println(res + ";");
    }

    //MODIFIES: this.Items
    //EFFECTS: add an Item into the Items of this individualStorage
    public void storeItem(String nm){
        if ((Items.size() + 1) <= maxCapacity){
            Item newItem = new unlimitedUse(nm);
            Items.add(newItem);
            verifyStore(newItem);
        }
        else {
            System.out.println("Sorry, this storage is full.");
        }
    }

    //EFFECTS: verify an item is added to the list of items of this storage or not
    public boolean verifyStore(Item i){
        if (this.Items.contains(i)){
            return true;
        }
        else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: add an item which is moved from another individual storage
    public void addItem(Item i){
        if ((Items.size() + 1) <= maxCapacity) {
            Items.add(i);
            System.out.println("Move this item successfully!");
        }
        else {
            System.out.println("Sorry, this storage is full.");
        }
    }

    //MODIFIES: this.Items
    //EFFECTS: add an Item into the Items of this individualStorage
    public void removeItem(Item i){
        boolean flag = false;
        for (Item S : this.Items){
            if (i.name.equals(S.name)){
                Items.remove(S);
                flag = true;
                break;
            }
        }

        if (!flag){
            System.out.println("Sorry, this item is not found in this storage.");
        }
    }
}
