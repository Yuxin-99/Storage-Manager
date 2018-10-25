package Model;

import Exceptions.fullStorage;
import Exceptions.noneExist;
import SaveLoad.Load;
import SaveLoad.Save;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager implements Load, Save{
    Scanner scanner = new Scanner(System.in);
    private ArrayList<individualStorage> availableStorage;

    public Manager(){
        availableStorage = new ArrayList<>();
    }

    public ArrayList<individualStorage> getAvailableStorage(){
        return availableStorage;
    }

    //EFFECTS: show all storage available
    public void displayStorage(){
        for (individualStorage s : availableStorage) {
            System.out.println(s.getName());
            s.display();
        }
    }

    //REQUIRES: this is a new storage which is not in the list before
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
        for (individualStorage s: availableStorage){
            if (s.getName().equals(manageStorage)){
                try {
                    s.doSomething(s);
                } catch (Exceptions.fullStorage fullStorage) {
                    fullStorage.result();
                }
                flag = true;
                break;
            }
        }
        if (!flag){
            throw new noneExist();
        }
    }

    //MODIFIES: individualStorage
    //EFFECTS: move an item from one individual storage to another
    public void move() throws noneExist {
        System.out.println("Where is the place this item is at now?");
        String originPlace = scanner.nextLine();
        boolean flag = false;
        for (individualStorage s : availableStorage){
            if (s.getName().equals(originPlace)){
                System.out.println("Please enter the name of the item you would like to remove.");
                String itName = scanner.nextLine();
                ordinaryItem it = new ordinaryItem(itName);
                s.removeItem(it);
                flag = true;
                System.out.println("Which place would you like to move this item to?");
                String isName = scanner.nextLine();
                Boolean check = false;
                for (individualStorage iS : availableStorage){
                    if (iS.getName().equals(isName)){
                        iS.addItem(it);
                        check = true;
                        break;
                    }
                }
                if (!check){
                    throw new noneExist();
                }
                break;
            }
        }
        if (!flag){
            throw new noneExist();
        }
    }

    public void delete(){
        System.out.println("You choose to discard an item.");
    }

    public List<String> save() throws IOException {
        PrintWriter writer = new PrintWriter("saveFile.txt","UTF-8");
        for (individualStorage i: availableStorage){
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
