package Model;

public abstract class Item {
    protected String name;
    protected int amount;
    protected individualStorage individualStorage;

    protected Item(String name){
        this.name = name;
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

    public void addAmount(int a){
        amount = amount + a;
    }

    public void showItem(){
        System.out.println("It's in Storage [" + individualStorage.getName()+ "]");
        System.out.println("The amount of this item is " + amount + ".");
    }
}
