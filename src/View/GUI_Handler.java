package View;

import Controllers.GameBoard;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;


public class GUI_Handler {


    public void UpdateBoard() {

        for (int counter = 0; counter < getGb().getGui().getFields().length; counter++) {

            getGb().getGui().getFields()[counter].removeAllCars();

            for (int i = 0; i < getGb().getPlayerArray().length; i++)

                getGb().getGui().getFields()[getGb().getPlayerArray()[i].getCurrentPosition()].setCar(getGb().getGuiArray()[i], true);

            for (int j = 0; j < getGb().getPlayerArray().length; j++)

                getGb().getGuiArray()[j].setBalance(getGb().getPlayerArray()[j].getAccount().getBalance());


        }
        // Why can't i use the same value for i in all of the loops? -Gullefar
        // I couldnt either when chosing colour - Alex
        // cute comments <3 - Anders
    }

public void setOwnerGUI() {

        GUI_Field f = getGb().getGui().getFields()[getGb().getCurrentPlayer().getCurrentPosition()];
        if (f instanceof GUI_Ownable) {
            GUI_Ownable o = (GUI_Ownable) f;
            o.setBorder(getGb().getCurrentGUIPlayer().getPrimaryColor(), getGb().getCurrentGUIPlayer().getSecondaryColor());

    }
}

    public GameBoard getGb(){
        return GameBoard.getInstance();
    }

    public void setDice() {

        getGb().getGui().setDie(getGb().getDie().getValue());

    }


}
