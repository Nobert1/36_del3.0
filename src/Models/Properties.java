package Models;

import Controllers.GameBoard;

import java.lang.reflect.Field;


public class Properties extends Fields {


    int price;
    String colour;
    public boolean owned;
    private Player owner;
    private GameBoard gb = GameBoard.getINSTANS();
    private Fields[] fields = GameBoard.getFIELD();



    public Properties(int position, String name, int price, String colour) {
        super(position, name);

    this.price = price;
    this.colour = colour;
    this.owned = false;
   // this.gb = new GameBoard();



}
//behøver vi fortælle spilleren hvilken farve de har landet på? selv en som mig der er farveblind kan godt se om de hører sammen eller ey
    @Override
    public String toString() {
        if(this.owned){
            return "You landed on square " + this.position + " which is owned by " + this.owner.getName() + " the rent is " + this.price + " dollar(s).";
        } else
        return "You landed on square " + this.position + " the price is " + this.price + " dollar(s).";
    }
    public void setOwned(boolean owned) {

        this.owned = owned;
        setOwner();
    }

    public void setOwner(){
        this.owner = gb.getPlayer();
        int newBalance = gb.getCurrentPlayer().getBalance() - getPrice();
        gb.getCurrentPlayer().setBalance(newBalance);
    }

    public Player getOwner(){
        return owner;
  }

    public int getPrice() {
        return price;
    }

    //man skal betale dobblet hvis man ejer to af samme farve)
    public void payRent(){
        int counter = 0;
        Properties[] propArray = new Properties[16];
        for (int i = 0; i < fields.length; i++) {
            String s1 = String.valueOf(fields[i].getClass());

            if (fields[i].getClass() == fields[getPosition()].getClass()) {

                propArray[counter] = (Properties) fields[i];
                counter++;
            }
        }

        int newPrice = getPrice();

        if(propArray[gb.getPlayer().getCurrentPosition()].getOwner() == propArray[gb.getPlayer().getCurrentPosition()+1].getOwner() ||
                propArray[gb.getPlayer().getCurrentPosition()].getOwner() == propArray[gb.getPlayer().getCurrentPosition()-1].getOwner()){
            newPrice = getPrice() * 2;
            gb.gui.showMessage("Because " + getOwner() + " owns both properties the rent is doubled");
        }

        int newBalance = gb.getPlayer().getAccount().getBalance() - newPrice;
        gb.getCurrentPlayer().setBalance(newBalance);
        int newBalance1 = owner.getAccount().getBalance() + newPrice;
        owner.getAccount().setBalance(newBalance1);
        gb.getCurrentPlayer().setBalance(newBalance1);
    }

    public String getColour() {
        return colour;
    }

    @Override
    public void FieldFunctionality() {


        if (!this.owned) {
            setOwned(true);
        } else {
            payRent();

        }

    }

    @Override
    public void OutputToGUI(){
    gb.gui.showMessage(toString());


    }

}


