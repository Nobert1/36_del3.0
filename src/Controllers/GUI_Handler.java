package Controllers;

import Controllers.GameBoard;



public class GUI_Handler {


    public void updatePlayerBalances() {

        for (int i = 0; i < getGb().getPlayerArray().length; i++)
            getGb().getGuiArray()[i].setBalance(getGb().getPlayerArray()[i].getAccount().getBalance());
        }


    public GameBoard getGb(){
        return GameBoard.getInstance();
    }

    public void removeplayer() {

        getGb().gui.getFields()[getGb().getCurrentPlayer().getCurrentPosition()].setCar(getGb().getCurrentGUIPlayer(), false);

    }

    public void movePlayer() {

        getGb().gui.getFields()[getGb().getCurrentPlayer().getCurrentPosition()].setCar(getGb().getCurrentGUIPlayer(), true);

    }


}
