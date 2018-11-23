package Models;

import Controllers.GameBoard;

public class Chance_Square extends Fields {


    private GameBoard gb = GameBoard.getInstance();


    public Chance_Square(int position, String name) {
        super(position, name);
    }

    @Override
    public void FieldFunctionality() {

        int i = 1+1;

    }

    @Override
    public void OutputToGUI(){
        gb.gui.showMessage(toString());


    }

    @Override
    public String toString() {
        return "You landed on field " + getPosition() + "wich is a change square, you are now going to draw a card";
    }

    @Override
    public int getPosition() {
        return super.getPosition();
    }
}
