package Models;


import Controllers.GameBoard;

public class Start extends Fields {

    private GameBoard gb = GameBoard.getINSTANS();

    public Start(int position, String name) {
        super(position, name);


    }

    @Override
    public void FieldFunctionality() {

        int i = gb.getCurrentPlayer().getBalance() + 2;
        gb.getCurrentPlayer().setBalance(i);
    }

    @Override
    public void OutputToGUI(){
        gb.gui.showMessage(toString());


    }


}

/**
 Den her klasse skal nok slettes, start har ingen funktionalitet i sig selv - Gustav.
 */