package Models;

import gui_fields.GUI_Player;

public class Properties extends Fields {


    int price;
    String colour;
    public boolean owned;
    private String owner;
    private GUI_Player gui_player;
    private BankAccount bankAccount;
    private Player[] playerarray;
    private Player player;
    private GUI_Player[] guiArray;



    public Properties(int position, String name, int price, String colour, String owner) {
        super(position, name);

    this.price = price;
    this.colour = colour;
    this.owned = false;
    this.owner = owner;


}

    @Override
    public String toString() {
        return " The square is placed at " + this.position + " the price/rent is " + this.price
                + " and the colour of the property is " + this.colour;
    }
    public void setOwned(boolean owned) {

        this.owned = true;
        setOwner(this.player.getName());


    }

    public void setOwner(String owner) {
        this.owner = owner;
        this.player.getAccount().withdraw(getPrice());
    }

    public String getOwner() {
        return owner;
    }

    /**
     * The below method has a small problem in the sense that it checks for player names.
     * If mulitiple people have the same name it's gonna deposit into all players of the same name.
     * If it is made to break after the first deposit it may not have deposited themoney into the correct account.
     * Perhaps changes have to be made.
     * - Gustav
     */
    public void GetRent() {
        for (int i = 0; i < playerarray.length; i++) {
            if (playerarray[i].getName().equals(this.getOwner())) {
                guiArray[i].setBalance(playerarray[i].getAccount().deposit(getPrice()));
                playerarray[i].getAccount().deposit(getPrice());

            } } }

            public void PayRent() {

            this.player.getAccount().withdraw(getPrice());

            }



    public int getPrice() {
        return price;
    }

    @Override
    public void FieldFunctionality() {

        if (!this.owned) {
            setOwned(true);

        } else {

            GetRent();
            PayRent();

        }

    }
}


