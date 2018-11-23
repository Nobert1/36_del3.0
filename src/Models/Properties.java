package Models;

import Controllers.GameBoard;
import gui_fields.GUI_Player;


public class Properties extends Fields {


    int price;
    String colour;
    public boolean owned;
    private GUI_Player owner;
    private GameBoard gb = GameBoard.getINSTANS();



    public Properties(int position, String name, int price, String colour) {
        super(position, name);

    this.price = price;
    this.colour = colour;
    this.owned = false;



}
//behøver vi fortælle spilleren hvilken farve de har landet på? selv en som mig der er farveblind kan godt se om de hører sammen eller ey
    @Override
    public String toString() {
        return "You landed on square " + this.position + " the price or rent is " + this.price
                + " and the colour of the property is " + this.colour;
    }
    public void setOwned(boolean owned) {

        this.owned = owned;
        setOwner();
    }

    public void setOwner(){
        this.owner = gb.getCurrentPlayer();
        int newBalance = gb.getCurrentPlayer().getBalance() + getPrice();
        gb.getCurrentPlayer().setBalance(newBalance);
    }

    public GUI_Player getOwner(){
        return owner;
  }

    public int getPrice() {
        return price;
    }

    //man skal betale dobblet hvis man ejer to af samme farve)
    public void payRent(){
        int newBalance = gb.getCurrentPlayer().getBalance() - getPrice();
        gb.getCurrentPlayer().setBalance(newBalance);
        int newBalance1 = owner.getBalance() + getPrice();
        owner.setBalance(newBalance1);

    }


    @Override
    public void FieldFunctionality() {


        if (!this.owned) {
            setOwned(true);
        } else {
            payRent();

        }

    }
}


