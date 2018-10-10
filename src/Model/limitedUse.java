package Model;

public class limitedUse extends Item{
    private int limitation;

    public limitedUse(String name){
        super(name);
        limitation = 0;
    }

    public String print(){
        return super.toString();
    }

    public void setLimitation(int i){
        limitation = i;
    }

    @Override
    public void showItem(){
        System.out.println("This is an item with a limited lifetime. The limitation is " + limitation + " days.");
        super.showItem();
    }
}
