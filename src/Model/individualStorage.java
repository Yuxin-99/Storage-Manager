package Model;

import Model.Items;
import Model.Item;
import java.util.ArrayList;
import java.util.Scanner;

public class individualStorage {
    public String name;
    private Items itemInStore;
    public Integer maxCapacity;

    public individualStorage(String name){
        itemInStore = new Items();
        this.name = name;
    }

    public Integer countItems(individualStorage s){
        Integer res = 0;
        for (Item S : s.itemInStore.Items){
            res++;
        }
        return res;
    }

    public void storeItem(Item newItem){
        itemInStore.Items.add(newItem);
        System.out.println("Store this item successfully!");
    }
}
