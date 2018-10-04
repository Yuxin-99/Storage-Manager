package Model;

public abstract class Item {
    protected String name;

    protected Item(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
