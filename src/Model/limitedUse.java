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
}