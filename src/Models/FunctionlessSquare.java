package Models;
import Controllers.GameBoard;

/**
 * Class dumb as fuck and isn't subject for change. Perhaps it is if Jail_visting ends up being obsolete as well,
 * then the toString method needs another output, but that's no bigge.
 * - comment by Gustav
 */

public class FunctionlessSquare extends Fields {

    private GameBoard gb = GameBoard.getInstance();

    public FunctionlessSquare(int position, String name) {
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
        if (getPosition() == 0)
        return "You landed" + getPosition() + "which is the start square, and it does litterally nowt";
        else {
            return "You landed" + getPosition() + "which is the parkering square, and it also does litterally nowt";
        }
    }
}