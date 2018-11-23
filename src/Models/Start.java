package Models;


import Controllers.GameBoard;

public class Start extends Fields {

    private GameBoard gb = GameBoard.getInstance();

    public Start(int position, String name) {
        super(position, name);


    }

    @Override
    public void FieldFunctionality() {


    }

    @Override
    public void OutputToGUI(){
        gb.gui.showMessage(toString());


    }

    @Override
    public String toString() {
        return "Youlanded" + getPosition() + "which is the " + getName() + "Square";
    }
}

/**
 Den her klasse skal nok slettes, start har ingen funktionalitet i sig selv - Gustav.
 */