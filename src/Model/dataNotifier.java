package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class dataNotifier implements Observer{
    private Integer amount;
    private List<String> newItems;

    public dataNotifier(){
        super();
        newItems = new ArrayList<>();
        amount = 0;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("New! " + arg + " in " + o);
        amount ++;
        newItems.add((String) arg);
    }

    public void print(){
        String res = "";
        for (String s: newItems){
            res = res + " " + s;
        }
        System.out.println(amount + " new items added:");
        System.out.println("[" + res + "]");
    }
}
