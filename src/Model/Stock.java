package Model;

import Exceptions.invalidLimit;

import java.util.List;
import java.util.Objects;
import java.util.Observable;

public abstract class Stock extends Observable{
    protected final String name;
    protected Integer maxCapacity;

    public Stock(String name){
        this.name = name;
        maxCapacity = null;
    }

    public String getName(){
        return name;
    }

    public void setMaxCapacity(int maximum) throws invalidLimit {
        if (maximum > 0){
            maxCapacity = maximum;
        } else {
            throw new invalidLimit();
        }
    }

    protected abstract String showStock();

    protected void display(){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(name, stock.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
