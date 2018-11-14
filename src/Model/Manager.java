package Model;

import Exceptions.noneExist;
import SaveLoad.Load;
import SaveLoad.Save;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Manager implements Load, Save{
    Scanner scanner = new Scanner(System.in);
    private HashMap<String,individualStorage> availableStorage;

    public Manager(){
        availableStorage = new HashMap<>();
    }

    public HashMap<String, individualStorage> getAvailableStorage(){
        return availableStorage;
    }

    //EFFECTS: show all storage available
    public void displayStorage(){
        for (individualStorage s : availableStorage.values()) {
            s.showStock();
        }
    }

    //REQUIRES: this is a new storage which is not in the list before
    //MODIFIES: availableStorage
    //EFFECTS: add a new individualStorage into availableStorage
    public void addNew(String nm){
        availableStorage.put(nm, new individualStorage(nm));
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

    //MODIFIES: individualStorage
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

    public void searchItem(){
        System.out.println("Please enter the name of this item.");
        String target = scanner.nextLine();
        boolean flag = false;
        for (individualStorage i: availableStorage.values()){
            if (i.getStocks().contains(new ordinaryItem(target))){
                flag = true;
                System.out.println("This item is in: " + i.getName());
            }
        } if (! flag){
            System.out.println("No such an item.");
        }
    }

    public List<String> save() throws IOException {
        PrintWriter writer = new PrintWriter("saveFile.txt","UTF-8");
        for (individualStorage i: availableStorage.values()){
            writer.println(i.getName());
            writer.println(i.getStocks());
        }
        writer.close();
        List<String> savefile = Files.readAllLines(Paths.get("saveFile.txt"));
        return savefile;
    }

    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputFile.txt"));
        return lines;
    }

}
