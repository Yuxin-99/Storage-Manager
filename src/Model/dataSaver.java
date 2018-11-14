package Model;

import java.util.Observable;
import java.util.Observer;

public class dataSaver implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("New item in " + arg);
    }
}
