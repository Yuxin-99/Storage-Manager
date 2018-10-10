package Model;

public abstract class Item {
    protected String name;
    protected int amount;

    protected Item(String name){
        this.name = name;
        amount = 1;
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

    public void addAmount(int a){
        amount = amount + a;
    }

    public void showItem(){
        System.out.println("The amount of this item is " + amount + ".");
    }
}
