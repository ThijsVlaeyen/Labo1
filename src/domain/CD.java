package domain;

public class CD extends Product {

    public CD(int id, String name) {
        super(id, name);
    }

    @Override
    public int getPrice(int days){
        return days>0? (int) (days * 1.5) : 0;
    }

    @Override
    public String toString(){
        return "\nType: CD" + super.toString();
    }
}
