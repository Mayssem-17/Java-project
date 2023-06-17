package Models;

public class Drink extends Item{
    private String size;

    public Drink(String name, Float price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return getName()+"......................"+getPrice()+"dt\nsize: " + size;
    }

    

    
}
