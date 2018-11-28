package Model;

import Exceptions.noneExist;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Manager{
    Scanner scanner = new Scanner(System.in);
    private HashMap<String, IndividualStorage> availableStorage;

    public Manager(){
        availableStorage = new HashMap<>();
    }

    public HashMap<String, IndividualStorage> getAvailableStorage(){
        return availableStorage;
    }

    //EFFECTS: show all storage available
    public String displayStorage(){
        String out = "";
        for (IndividualStorage s : availableStorage.values()) {
            out = out + "\n" + s.showStock();
        }
        return out;
    }

    //REQUIRES: this is a new storage which is not in the list before
    //MODIFIES: availableStorage
    //EFFECTS: add a new IndividualStorage into availableStorage
    public void addNew(String nm){
        availableStorage.put(nm, new IndividualStorage(nm));
    }

    //EFFECTS: verify a new storage is added to the availableStorage or not
    private boolean verifyStorage(String inSt){
        return availableStorage.containsKey(inSt);
    }

    public void manageOne() throws noneExist {
        System.out.println("Please enter the storage you want to manage");
        String manageStorage = scanner.nextLine();
        if(verifyStorage(manageStorage)){
            try {
                availableStorage.get(manageStorage).furtherManage();
            } catch (Exceptions.fullStorage fullStorage) {
                fullStorage.result();
            }
        }
        else {throw new noneExist();}
    }

    //MODIFIES: IndividualStorage
    //EFFECTS: move an item from one individual storage to another
    public void move() throws noneExist {
        System.out.println("Where is the place this item is at now?");
        String originPlace = scanner.nextLine();
        if (verifyStorage(originPlace)){
            System.out.println("Please enter the name of the item you would like to remove.");
            String itName = scanner.nextLine();
            System.out.println("Which place would you like to move this item to?");
            String isName = scanner.nextLine();
            if (verifyStorage(isName)){
                try {
                    Item it = availableStorage.get(originPlace).getItem(itName);
                    availableStorage.get(isName).addItem(it);
                    it.setIndividualStorage(isName);
                    availableStorage.get(originPlace).moveItem(itName);
                } catch (Exceptions.fullStorage fullStorage) {
                    System.out.println("Sorry, this storage is full.");
                }
            } else {
                throw new noneExist();
            }
        } else {
            throw new noneExist();
        }
    }

    public String searchItem(String target){
//        System.out.println("Please enter the name of this item.");
//        String target = scanner.nextLine();
        String pos = "";
        boolean flag = false;
        for (IndividualStorage i: availableStorage.values()){
            if (i.getStocks().contains(new OrdinaryItem(target))){
                flag = true;
                pos = i.getName();
                //System.out.println("This item is in: " + i.getName());
            }
        } if (! flag){
            pos = "No such an item.";
        }
        return pos;
    }

    //public IndividualStorage current

}
