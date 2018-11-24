package Model;

import Exceptions.invalidLimit;
import javafx.beans.InvalidationListener;

public class LimitedUse extends Item{
    private int limitation;

    public LimitedUse(String name){
        super(name);
        limitation = 0;
    }

    public String print(){
        return super.toString();
    }

    public void setLimitation(int i) throws invalidLimit{
        if (i > 0){
            limitation = i;
        } else{
            throw new invalidLimit();
        }
    }

    @Override
    public void display(){
        System.out.println("This is an item with a limited lifetime. The limitation is " + limitation + " days.");
        super.display();
    }

}
