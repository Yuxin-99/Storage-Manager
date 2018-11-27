package Model;

public abstract class Item extends Stock{
    protected int amount;
    protected IndividualStorage IndividualStorage;

    public Item(String name){
        super(name);
        amount = 1;
    }

    public void setIndividualStorage(String snm){
        IndividualStorage = new IndividualStorage(snm);
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

    public IndividualStorage getIndividualStorage(){
        return IndividualStorage;
    }

    public void addAmount(){
        amount++;
    }

    public String showStock(){
        return super.name;
    }

    public void display(){
        System.out.println("It's in StorageIcon [" + IndividualStorage.getName()+ "]");
        System.out.println("The amount of " + name + " is " + amount + ".");
    }


}
