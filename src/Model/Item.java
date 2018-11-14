package Model;

import javafx.beans.Observable;

import java.util.Objects;
import java.util.Observer;

public abstract class Item extends Stock{
    protected int amount;
    protected individualStorage individualStorage;

    public Item(String name){
        super(name);
        amount = 1;
    }

    public void setIndividualStorage(String snm){
        individualStorage = new individualStorage(snm);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public individualStorage getIndividualStorage(){
        return individualStorage;
    }

    public void addAmount(){
        amount++;
    }

    public void showStock(){
        System.out.println(super.name);
    }

    public void display(){
        System.out.println("It's in Storage [" + individualStorage.getName()+ "]");
        System.out.println("The amount of " + name + " is " + amount + ".");
    }


}
