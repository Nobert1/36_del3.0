package Models;
import Controllers.GameBoard;
import Models.Fields.*;

/**
 * Class dumb as fuck and isn't subject for change. Perhaps it is if Jail_visting ends up being obsolete as well,
 * then the toString method needs another output, but that's no bigge.
 * - comment by Gustav
 */

public class FunctionlessSquare extends Fields {

    public GameBoard getGb(){
        return GameBoard.getInstance();
    }

    public FunctionlessSquare(int position, String name) {
        super(position, name);
    }

    @Override
    public void FieldFunctionality() {}

    @Override
    public void OutputToGUI(){
        getGb().getGui().showMessage(toString());
    }

    @Override
    public String toString() {
        if (getPosition() == 0) {
        return "You landed on " + getGb().getCurrentPlayer().getCurrentPosition()+ " which is the start square, and it does litterally nowt"; }

        else if (getPosition() == 6){
            return "You landed on " + getGb().getCurrentPlayer().getCurrentPosition() + " which is the visting jail square, and it does litterally nowt"; }

        else {
            return "You landed on " + getGb().getCurrentPlayer().getCurrentPosition() + " which is the parking square, and it also does litterally nowt"; }

    }
}