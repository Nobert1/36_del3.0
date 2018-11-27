package Models;
import Controllers.GameBoard;
import gui_fields.GUI_Player;


/**
 * Atm this class is a litle bit messy, it needs some cleaning up after we figure out what to do with double rent.
 * Everything else is working like a german machine.
 * - comment by Gustav
 */

public class Properties extends Fields {


    int price;
    int sisterIndex;
    public boolean owned;
    private Player owner;
    private GameBoard gb = GameBoard.getInstance();

    public Properties(int position, String name, int price, int sisterIndex) {
        super(position, name);

    this.price = price;
    this.sisterIndex = sisterIndex;
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
        if(!gb.getCurrentGUIPlayer().isPayNothing()) {
            gb.getPlayer().getAccount().withdraw(getPrice());
        } else {
            gb.getCurrentGUIPlayer().setPayNothing(false);
        }
    }

    public Player getOwner(){
        return owner;
  }

    public int getPrice() {
        return this.price;
    }

    //man skal betale dobblet hvis man ejer to af samme farve
    public void payRent(){
        boolean ownsAll = false;
        int counter = 0;
        Properties[] propArray = new Properties[16];
        int priceCounter = 0;
        /**
         * Den her fremgangsmåde virker ikke og det kommer den nok hellere ikke til. For nu tror jeg ikke det er
         * der hvor vi skal lægge vores tid. Den .getclass funktion vi kalder ved vi i bund og grund ikke hvad gør
         * og jeg tror heller ikke den kommer til at kunne gøre noget fedt.
         */
        /*for (int i = 0; i < 24; i++) {
            if (gb.getFI().getField(i).getClass().isInstance(Properties.class)) {
                //if ((Object) gb.getFI().getField(i).getClass() instanceof Properties) {

                    propArray[counter] = (Properties) gb.getFI().getField(i);
                counter++;

            }
            int propArrayPlayerPos = gb.getPlayer().getCurrentPosition() - gb.getPlayer().getCurrentPosition()/3;
            for (int j = 0; j < propArray.length; j++) {
                if (propArray[j].getSisterIndex() ==
                        ((Properties) gb.getFI().getField(gb.getPlayer().getCurrentPosition())).getSisterIndex()) {
                    if (propArray[j].getOwner() == propArray[propArrayPlayerPos].getOwner()) {
                        priceCounter++;
                    }
                }
            }
        }
        if (priceCounter == 2) {
            ownsAll = true;
            gb.gui.showMessage("Because " + getOwner() + " owns both properties the rent is doubled");
        }*/

        owner.getAccount().deposit((ownsAll ? 2 * getPrice() : getPrice()));

        gb.getPlayer().getAccount().withdraw(ownsAll ? 2 * getPrice() : getPrice());

    }

    @Override
    public void FieldFunctionality() {
        if (!this.owned) {
            setOwned(true);
        } else {
            payRent();
        }
    }

    public int getSisterIndex() {
        return sisterIndex;
    }

    @Override
    public void OutputToGUI(){
    gb.gui.showMessage(toString());


    }


}


