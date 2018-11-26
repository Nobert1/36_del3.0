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
    public void FieldFunctionality() {}

    @Override
    public void OutputToGUI(){
        gb.gui.showMessage(toString());
    }

    @Override
    public String toString() {
        if (gb.getPlayer().getCurrentPosition() == 0) {
        return "You landed on " + gb.getPlayer().getCurrentPosition()+ ", the start square."; }

        else if (gb.getPlayer().getCurrentPosition() == 6){
            return "You landed on " + gb.getPlayer().getCurrentPosition() + " which is the visiting jail square, and it does literally nowt"; }

        else {
            return "You landed on " + gb.getPlayer().getCurrentPosition() + " which is the parking square, and it also does literally nowt"; }

    }
}