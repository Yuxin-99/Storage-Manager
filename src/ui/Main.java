package ui;

import Model.Storage;
import Model.individualStorage;
import SaveLoad.Load;
import SaveLoad.Save;

import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main implements Load, Save{
    static Scanner scanner = new Scanner(System.in);
    public static Storage allStorage;

    public Main(){
        allStorage = new Storage();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String option = "";
        allStorage.addNew("bookshelf");
        allStorage.addNew("plastic case");
        allStorage.addNew("wardrobe");
        allStorage.availableStorage.get(0).setMaxCapacity(6);
        allStorage.availableStorage.get(1).setMaxCapacity(3);
        allStorage.availableStorage.get(2).setMaxCapacity(10);

        allStorage.availableStorage.get(0).storeItem("dictionary");
        allStorage.availableStorage.get(0).storeItem("laptop");
        allStorage.availableStorage.get(1).storeItem("lipstick");
        allStorage.availableStorage.get(1).storeItem("scarf");
        allStorage.availableStorage.get(2).storeItem("coats");

        while (true){
            System.out.println("Welcome to your storage manager! What would you like to do? [1]display the whole storage, [2]add a storage, [3]add an item, [4]move an item to a new place,");
            System.out.println("[5]discard an item, [6]save the information, [7]load a file, [8]quit. Please choose one number as your option.");
            option = scanner.nextLine();
            if (option.equals("1")){
                allStorage.displayStorage();
            }

            else if (option.equals("2")){
                System.out.println("Please enter the name of the new storage.");
                String stName = scanner.nextLine();
                allStorage.addNew(stName);
            }

            else if (option.equals("3")){
                allStorage.StorageToStore();
            }

            else if (option.equals("4")){
                allStorage.move();
            }

            else if (option.equals("5")){
                allStorage.delete();
            }

            else if (option.equals("6")){
                Main m = new Main();
                m.save();
            }

            else if (option.equals("7")){
                Main m =new Main();
                m.load();
            }

            else if (option.equals("8")){

            }
        }
    }

    @Override
    public List<String> save() throws IOException{
        PrintWriter writer = new PrintWriter("saveFile.txt","UTF-8");
        for (individualStorage i: allStorage.availableStorage){
            writer.println(i.name);
            writer.println(i.Items);
        }
        writer.close();
        List<String> savefile = Files.readAllLines(Paths.get("saveFile.txt"));
        return savefile;
    }

    @Override
    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputFile.txt"));
        return lines;
    }
}
