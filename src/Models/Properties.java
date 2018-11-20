package Models;

public class Properties extends Fields {

    int rent;
    int price;
    String colour;
    public boolean owned;

public Properties(int position, String name, int rent, int price, String colour) {
        super(position, name);
    this.rent = rent;
    this.price = price;
    this.colour = colour;
    this.owned = false;
}

    @Override
    public String toString() {
        return " The square is placed at " + this.position + " the price is " + this.price + " The rent is "+ this.rent + " and the colour of the property is " + this.colour;
    }

    public void setOwned(boolean owned) {
        this.owned = true;
    }

}


