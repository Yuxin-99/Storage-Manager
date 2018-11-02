package Model;

import Exceptions.fullStorage;
import Exceptions.invalidLimit;
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
            System.out.println(s.getName());
            s.display();
        }
    }

    //REQUIRES: this is a new storage which is not in the list before
    //MODIFIES: availableStorage
    //EFFECTS: add a new individualStorage into availableStorage
    public void addNew(String nm){
        individualStorage newIndividual = new individualStorage(nm);
        availableStorage.put(nm, newIndividual);
        verifyAddedStorage(newIndividual);
    }

    //EFFECTS: verify a new storage is added to the availableStorage or not
    public boolean verifyAddedStorage(individualStorage inSt){
        if (this.availableStorage.containsKey(inSt.getName())){
            return true;
        }
        else {
            return false;
        }
    }

    public void manageOne() throws noneExist {
        System.out.println("Please enter the storage you want to manage");
        String manageStorage = scanner.nextLine();
        boolean flag = false;
        //for (individualStorage s: availableStorage){
        if(availableStorage.containsKey(manageStorage)){
            try {
                availableStorage.get(manageStorage).doSomething();
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
        if (availableStorage.containsKey(originPlace)){
            System.out.println("Please enter the name of the item you would like to remove.");
            String itName = scanner.nextLine();
            ordinaryItem it = new ordinaryItem(itName);
            System.out.println("Which place would you like to move this item to?");
            String isName = scanner.nextLine();
            if (availableStorage.containsKey(isName)){
                try {
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

    public List<String> save() throws IOException {
        PrintWriter writer = new PrintWriter("saveFile.txt","UTF-8");
        for (individualStorage i: availableStorage.values()){
            writer.println(i.getName());
            writer.println(i.getItems());
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
