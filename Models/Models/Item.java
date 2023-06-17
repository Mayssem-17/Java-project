package Models;

public class Item {
    private String name;
    private float price;

    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", price=" + price + "]";
    }

    public void updateNameAndPrice(String newName, float newPrice) {
        this.name = newName;
        this.price = newPrice;
    }
}
