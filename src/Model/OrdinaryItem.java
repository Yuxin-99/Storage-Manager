package Model;

//import javafx.beans.InvalidationListener;

public class OrdinaryItem extends Item{
    public OrdinaryItem(String name){
        super(name);
    }

    @Override
    public void display(){
        System.out.println("This is an ordinary item.");
        super.display();
    }

}
