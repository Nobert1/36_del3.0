package Models;

import Controllers.GameBoard;

public class Chance_Square extends Fields {


    private GameBoard gb = GameBoard.getINSTANS();


    public Chance_Square(int position, String name) {
        super(position, name);
    }

    @Override
    public void FieldFunctionality() {

    }

    @Override
    public void OutputToGUI(){
        gb.gui.showMessage(toString());


    }
}
