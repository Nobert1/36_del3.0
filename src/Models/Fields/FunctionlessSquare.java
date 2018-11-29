package Models.Fields;
import Controllers.GameBoard;
import Models.Fields.Fields;

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
        if (getGb().getCurrentPlayer().getCurrentPosition() == 0) {
        return "You landed on " + getGb().getCurrentPlayer().getCurrentPosition()+ ", the start square."; }

        else if (getGb().getCurrentPlayer().getCurrentPosition() == 6){
            return "You landed on " + getGb().getCurrentPlayer().getCurrentPosition() + " which is the visiting jail square, and it does literally nowt"; }

        else {
            return "You landed on " + getGb().getCurrentPlayer().getCurrentPosition() + " which is the parking square, and it also does literally nowt"; }

    }
}