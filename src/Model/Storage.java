package Model;

import Model.individualStorage;
import Model.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<individualStorage> availableStorage;

    public Storage(){
        availableStorage = new ArrayList<>();
    }

    public void displayStorage(){
        System.out.println("You choose to " + "display the whole storage.");
        for (individualStorage s : availableStorage) {
            System.out.println("Storage" + availableStorage.indexOf(s) + " " + "[" + s.name + "]");
            s.display();
        }

    }

    //MODIFIES: availableStorage
    //EFFECTS: add a new individualStorage into availableStorage
    public void addNew(String nm){
        individualStorage newIndividual = new individualStorage(nm);
        availableStorage.add(newIndividual);
        verifyAddedStorage(newIndividual);
    }

    //EFFECTS: verify a new storage is added to the availableStorage or not
    public boolean verifyAddedStorage(individualStorage inSt){
        if (this.availableStorage.contains(inSt)){
            System.out.println("The new storage is added successfully!");
            return true;
        }
        else {
            return false;
        }
    }

    public void StorageToStore(){
        System.out.println("You choose to " + "add an item.");
        String chooseIndividual = "";
        System.out.println("Where would you like to store this item?");
        chooseIndividual = scanner.nextLine();
        boolean flag = false;
        for (individualStorage s : availableStorage){
            if (s.name.equals(chooseIndividual)){
                String itName = "";
                System.out.println("Please enter the name of the item you would like to store.");
                itName = scanner.nextLine();
                s.storeItem(itName);
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("Sorry. The storage you entered doesn't exist.");
        }
    }

    public void move(){
        System.out.println("You choose to move an item to a new place.");
        System.out.println("Where is the place this item is at now?");
        String originPlace = scanner.nextLine();
        boolean flag = false;
        for (individualStorage s : availableStorage){
            if (s.name.equals(originPlace)){
                System.out.println("Please enter the name of the item you would like to remove.");
                String itName = scanner.nextLine();
                Item it = new Item(itName);
                s.removeItem(it);
                flag = true;
                System.out.println("Which place would you like to move this item to?");
                String isName = scanner.nextLine();
                Boolean check = false;
                for (individualStorage iS : availableStorage){
                    if (iS.name.equals(isName)){
                        iS.addItem(it);
                        check = true;
                        break;
                    }
                }
                if (!check){
                    System.out.println("Sorry. The storage you entered doesn't exist.");
                }
                break;
            }
        }
        if (!flag){
            System.out.println("Sorry. The storage you entered doesn't exist.");
        }
    }

    public void delete(){
        System.out.println("You choose to discard an item.");
    }

}
