package View;

import Controllers.GameBoard;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;


public class GUI_Handler {


    public void UpdateBoard() {

        for (int counter = 0; counter < getGb().gui.getFields().length; counter++) {

            getGb().gui.getFields()[counter].removeAllCars();

            for (int i = 0; i < getGb().getPlayerArray().length; i++)

                getGb().gui.getFields()[getGb().getPlayerArray()[i].getCurrentPosition()].setCar(getGb().getGuiArray()[i], true);

            for (int j = 0; j < getGb().getPlayerArray().length; j++)

                getGb().getGuiArray()[j].setBalance(getGb().getPlayerArray()[j].getAccount().getBalance());


        }
        // Why can't i use the same value for i in all of the loops? -Gullefar
        // I couldnt either when chosing colour - Alex
    }

public void setOwnerGUI() {

        GUI_Field f = getGb().gui.getFields()[getGb().getCurrentPlayer().getCurrentPosition()];
        if (f instanceof GUI_Ownable) {
            GUI_Ownable o = (GUI_Ownable) f;
            o.setBorder(getGb().getCurrentGUIPlayer().getPrimaryColor(), getGb().getCurrentGUIPlayer().getSecondaryColor());

    }
}

    public GameBoard getGb(){
        return GameBoard.getInstance();
    }


    public void setupBoard() {

        for (int i = 0; i < getGb().getGuiArray().length; i++) {

            getGb().gui.addPlayer(getGb().getGuiArray()[i]);

        }


    }
    public void setDice() {

        getGb().gui.setDie(getGb().getDie().getValue());

    }


}
