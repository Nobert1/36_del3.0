package Models.Fields;
import Controllers.GameBoard;
import Models.Player;
import View.GUI_Handler;


/**
 * Atm this class is a litle bit messy, it needs some cleaning up after we figure out what to do with double rent.
 * Everything else is working like a german machine.
 * - comment by Gustav
 */

public class Properties extends Fields {


    private int price;
    private int sisterIndex;
    private boolean owned;
    private Player owner;
    private GUI_Handler handler = new GUI_Handler();


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

        this.owned = owned;
    }

    public void newOwner() {

        if (getOwner().isPayNothing() == false) {
            getOwner().getAccount().withdraw(getPrice());
        } else {
            getOwner().setPayNothing(false);
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

        /**
         * The first if checkments check it the player position is 24, if that is the case the other method will check
         * for a position which is out of bounds. We can take modolus to 25 and then it will check the start position instead
         * but this way we know it doesnt provide us with any error. The second if statement checks for the fields
         * right next to the players position. If they arent properties it will throw an exception but we catch that
         * so that the system keeps running.
         */
        try {
if (getGb().getCurrentPlayer().getCurrentPosition() == 23 && ((Properties) getGb().getFI().getField(getGb().getCurrentPlayer()
        .getCurrentPosition())).getOwner() ==
        ((Properties) getGb().getFI().getField(getGb().getCurrentPlayer().getCurrentPosition() - 1)).getOwner()) {
            ownsAll = true;
        }

                //This statement makes it so that it's only stepped into if the player position isn't 23. If it is 23 it will
                    //cast an outofbounds exception.
                    if (getGb().getCurrentPlayer().getCurrentPosition() != 23 && ((Properties) getGb().getFI().getField(getGb().getCurrentPlayer().getCurrentPosition())).getOwner() ==
                            ((Properties) getGb().getFI().getField(getGb().getCurrentPlayer().getCurrentPosition() - 1)).getOwner() ||
                            (((Properties) getGb().getFI().getField(getGb().getCurrentPlayer().getCurrentPosition())).getOwner() ==
                                    ((Properties) getGb().getFI().getField(getGb().getCurrentPlayer().getCurrentPosition() + 1)).getOwner())) {
                        ownsAll = true;
                    }

        } catch (ClassCastException e) {


        }
        if (ownsAll == true){
            getGb().getGui().showMessage("Because " + this.owner.getName() + "owns both properties the rent is doubled");
        }

        owner.getAccount().deposit((ownsAll ? 2 * getPrice() : getPrice()));

        getGb().getCurrentPlayer().getAccount().withdraw(ownsAll ? 2 * getPrice() : getPrice());

    }

    @Override
    public void FieldFunctionality() {
        if (!this.owned) {
            setOwned(true);
            setOwner(getGb().getCurrentPlayer());
            newOwner();
            handler.setOwnerGUI();
        } else {
            payRent();
        }
    }


    @Override
    public void OutputToGUI(){
        getGb().getGui().showMessage(toString());


    }

    public void setOwner(Player owner) { this.owner = owner; }

    public boolean getOwned() {return this.owned;}
}


