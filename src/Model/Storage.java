package Model;

import Model.individualStorage;
import Model.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<individualStorage> availableStorage;

    public Storage(){
        this.availableStorage = new ArrayList<>();
    }

    public void addNew(){
        String stName = "";
        System.out.println("Please enter the name of the new storage.");
        stName = scanner.nextLine();
        individualStorage newIndividual = new individualStorage(stName);
        availableStorage.add(newIndividual);
    }

    public void StorageToStore(String individual){
        boolean flag = false;
        for (individualStorage s : availableStorage){
            if (s.name.equals(individual)){
                String itName = "";
                System.out.println("Please enter the name of the item you would like to store.");
                itName = scanner.nextLine();
                Item newItem = new Item(itName);
                s.storeItem(newItem);
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("Sorry. The storage you entered doesn't exist.");
        }
    }

    public void displayAllItems(){

    }

    public Integer countStorage(){
        Integer res = 0;
        for (individualStorage S : availableStorage){
            res ++;
        }
        return res;
    }

}
