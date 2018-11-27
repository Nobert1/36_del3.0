package Models;
import Controllers.GameBoard;
import Models.Fields.Fields;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;


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


    public Properties(int position, String name, int price, int sisterIndex) {
        super(position, name);

    this.price = price;
    this.sisterIndex = sisterIndex;
    this.owned = false;



}
    public GameBoard getGb(){
        return GameBoard.getInstance();
    }

    @Override
    public String toString() {
        if(this.owned){
            if(this.owner == getGb().getCurrentPlayer()){
                return "You landed on square " + this.position + " which is owned by you!";
            }
            return "You landed on square " + this.position + " which is owned by " + this.owner.getName() +
                    " the rent is " + this.price + " dollar(s).";
        } else
        return "You landed on square " + this.position + " the price is " + this.price + " dollar(s).";
    }

    public void setOwned(boolean owned) {

        this.owned = true;
        setOwner();
    }

    public void setOwner() {

        this.owner = getGb().getCurrentPlayer();
        if (!getGb().getCurrentGUIPlayer().isPayNothing()) {
            getGb().getCurrentPlayer().getAccount().withdraw(getPrice());
        } else {
            getGb().getCurrentGUIPlayer().setPayNothing(false);
        }
        GUI_Field f = getGb().gui.getFields()[getGb().getCurrentPlayer().getCurrentPosition()];
        if (f instanceof GUI_Ownable){
            GUI_Ownable o = (GUI_Ownable)f;
            o.setBorder(getGb().getCurrentGUIPlayer().getPrimaryColor(), getGb().getCurrentGUIPlayer().getSecondaryColor());
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
            int propArrayPlayerPos = gb.getCurrentPlayer().getCurrentPosition() - gb.getCurrentPlayer().getCurrentPosition()/3;
            for (int j = 0; j < propArray.length; j++) {
                if (propArray[j].getSisterIndex() ==
                        ((Properties) gb.getFI().getField(gb.getCurrentPlayer().getCurrentPosition())).getSisterIndex()) {
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

        getGb().getCurrentPlayer().getAccount().withdraw(ownsAll ? 2 * getPrice() : getPrice());

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
        getGb().gui.showMessage(toString());


    }


}


