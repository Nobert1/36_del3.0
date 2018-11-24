package Models;

import Controllers.GameBoard;
import gui_fields.GUI_Player;


public class Properties extends Fields {


    int price;
    String colour;
    public boolean owned;
    private Player owner;
    private GameBoard gb = GameBoard.getInstance();
    private Board fields = gb.getFIELDSINSTANS();



    public Properties(int position, String name, int price, String colour) {
        super(position, name);

    this.price = price;
    this.colour = colour;
    this.owned = false;


}
//behøver vi fortælle spilleren hvilken farve de har landet på? selv en som mig der er farveblind kan godt se om de hører sammen eller ey
    @Override
    public String toString() {
        if(this.owned){
            return "You landed on square " + this.position + " which is owned by " + this.owner.getName() +
                    " the rent is " + this.price + " dollar(s).";
        } else
        return "You landed on square " + this.position + " the price is " + this.price + " dollar(s).";
    }
    public void setOwned(boolean owned) {

        this.owned = true;
        setOwner();

    }

    public void setOwner(){
        this.owner = gb.getPlayer();
        gb.getPlayer().getAccount().withdraw(getPrice());
        //this.name += "\n" + getOwner();
    }

    public Player getOwner(){
        return owner;
  }

    public int getPrice() {
        return this.price;
    }

    //man skal betale dobblet hvis man ejer to af samme farve
    public void payRent(){
        int counter = 0;
        Properties[] propArray = new Properties[16];
        int newPrice = getPrice();


        /**
         * Den her fremgangsmåde virker ikke og det kommer den nok hellere ikke til. For nu tror jeg ikke det er
         * der hvor vi skal lægge vores tid. Den .getclass funktion vi kalder ved vi i bund og grund ikke hvad gør
         * og jeg tror heller ikke den kommer til at kunne gøre noget fedt.
         */
        /*for (int i = 0; i < 24; i++) {
            //if (fields.getField(i).getClass() == Properties.class) {
            if(fields.getField(gb.getPlayer().getCurrentPosition()).getClass() == fields.getField(i).getClass()) {

                propArray[counter] = (Properties) fields.getField(i);
                counter++;

            } }


        if  (propArray[gb.getPlayer().getCurrentPosition()].getOwner() == propArray[gb.getPlayer().getCurrentPosition()+1].getOwner() ||
                propArray[gb.getPlayer().getCurrentPosition()].getOwner() == propArray[gb.getPlayer().getCurrentPosition()-1].getOwner()) {
            newPrice = getPrice() * 2;
            gb.gui.showMessage("Because " + getOwner() + " owns both properties the rent is doubled");
        }*/

        gb.getPlayer().getAccount().withdraw(newPrice);

        owner.getAccount().deposit(newPrice);


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


