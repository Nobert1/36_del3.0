package Models.Fields;
import Controllers.GameBoard;
import Models.Player;


/**
 * Property class which handles with owners and rent
 */

public class Properties extends Fields {


    private int price;
    private boolean owned;
    private Player owner;

    public Properties(int position, String name, int price) {
        super(position, name);

    this.price = price;
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

    //Setd Property to owned
    public void setOwned(boolean owned) {

        this.owned = owned;
    }

    //defines owner
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

    //Method to pay rent, which checks if the player owns both properties of the same colour.
    public void payRent(){

        boolean ownsAll = false;

        /**
         * The first if checks if the player position is 24, if that is the case the other method will check
         * for a position which is out of bounds. The second if statement checks for the fields
         * right next to the players position. If they aren't properties it will throw an exception but we catch that
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
            getGb().getHandler().setOwnerGUI();
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


