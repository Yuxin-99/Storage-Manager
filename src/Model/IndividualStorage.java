package Model;

import java.util.*;

import Exceptions.invalidLimit;
import Exceptions.noneExist;
import Exceptions.fullStorage;

public class IndividualStorage extends Stock {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Stock> stocks;
    private DataNotifier d = new DataNotifier();

    public IndividualStorage(String name){
        super(name);
        stocks = new ArrayList<>();
        addObserver(d);
    }

    public ArrayList<Stock> getStocks(){
        return stocks;
    }

    public void furtherManage() throws noneExist, fullStorage {
        while (true) {
            System.out.println("Please select the option you want to do.");
            String command = inputString("[1]display this storage, [2]show details of item, [3]Add an inside storage, [4]store an item to this storage, [5]discard an item from this storage, [6]set a maxCapacity, [7]finish this management");
            if (command.equals("1")) {
                showStock();
            } else if (command.equals("2")) {
                String itName = inputString("Please enter the name of the item.");
                Stock i = getItem(itName);
                i.display();
            } else if (command.equals("3")){
                String storageName = inputString("Please enter the name of this storage");
                Stock s = new IndividualStorage(storageName);
                stocks.add(s);
            } else if (command.equals("4")) {
                if (maxCapacity == null || stocks.size() < maxCapacity){
                    String itName = inputString("Please enter the name of the item you would like to store.");
                    Item newItem = new OrdinaryItem(itName);
                    if (stocks.contains(newItem)){
                        try {
                            getItem(itName).addAmount();
                            setChanged();
                            notifyObservers(itName);
                        } catch (Exceptions.noneExist noneExist) {}
                    } else {
                        String type = inputString("Does this item has a limited lifetime? Reply yes or no.");
                        if (type.equals("yes")) {
                            storeItem0(itName);
                        } else if (type.equals("no")) {
                            storeItem1(itName);
                        }
                    }
                } else {
                     throw new fullStorage();
                }
            } else if (command.equals("5")) {
                String itName = inputString("Please enter the name of the item you would like to discard.");
                try {
                    moveItem(itName);
                } catch (noneExist e){
                    System.out.println("Sorry, this item is not found.");
                }
            } else if (command.equals("6")){
                System.out.println("Please give a max capacity(integer)");
                while (true){
                    int max = Integer.parseInt(scanner.nextLine());
                    try {
                        setMaxCapacity(max);
                    } catch (invalidLimit e){
                        e.result();
                    }
                }
            } else if (command.equals("7")) {
                d.print();
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    private String inputString(String s) {
        System.out.println(s);
        return scanner.nextLine();
    }

    //EFFECTS: show all items in this individual storage
    public void showStock(){
        System.out.println("[" + super.name + "]");
        for (Stock stock: stocks) {
            stock.showStock();
        }
    }

    //REQUIRES: this is an new item which is not in the list
    //MODIFIES: this.stocks
    //EFFECTS: add an Item with limited lifetime into the stocks of this IndividualStorage
    public void storeItem0(String nm) {
        LimitedUse newItem = new LimitedUse(nm);
        System.out.println("How long is its lifetime? (days)");
        while (true) {
            int lim = Integer.parseInt(scanner.nextLine());
            try {
                newItem.setLimitation(lim);
                stocks.add(newItem);
                newItem.setIndividualStorage(name);
                setChanged();
                notifyObservers(nm);
                break;
            } catch (invalidLimit e){
                e.result();
            }
        }
    }

    //REQUIRES: this is an new item which is not in the list before
    //MODIFIES: this.stocks
    //EFFECTS: add an OrdinaryItem into the stocks of this IndividualStorage
    public void storeItem1(String nm){
        Item newItem = new OrdinaryItem(nm);
        stocks.add(newItem);
        newItem.setIndividualStorage(name);
        setChanged();
        notifyObservers(nm);
    }

    //MODIFIES: this
    //EFFECTS: add an item which is moved from another individual storage
    public void addItem(Item i) throws fullStorage {
        if (maxCapacity == null || (stocks.size() + 1) <= maxCapacity){
            if (stocks.contains(i)){
                try {
                    getItem(i.getName()).addAmount();
                } catch (Exceptions.noneExist noneExist) {}
            } else {
                stocks.add(i);
                setChanged();
                notifyObservers(i.getName());
            }
            i.setIndividualStorage(this.getName());
        } else {
            if ((stocks.size() + 1) > maxCapacity){
                stocks.remove(i);
                throw new fullStorage();
            }
        }
    }

    public void moveItem(String nm) throws noneExist {
        stocks.remove(getItem(nm));
    }

    public List<Item> getItems(){
        List<Item> items = new ArrayList<>();
        for (Stock s: stocks){
            if (s instanceof Item){
                items.add((Item) s);
            }
        }
        return items;
    }

    public Item getItem(String itName) throws noneExist {
        boolean flag = false;
        Item res = null;
        for (Item it : getItems()) {
            if (it.getName().equals(itName)) {
                flag = !flag;
                res = it;
            }
        }
        if (!flag) {
            throw new noneExist();
        }
        return res;
    }

    @Override
    public String toString() {
        return "{'" + name + '\'' + '}';
    }
}
