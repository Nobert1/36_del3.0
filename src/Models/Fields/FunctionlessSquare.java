package Models.Fields;
import Controllers.GameBoard;
import Models.Fields.Fields;

/**
 * Class for all the squares which have no greater function that a message
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
            return "You landed on " + getGb().getCurrentPlayer().getCurrentPosition() + " which is the visiting jail square, and it does nothing"; }

        else {
            return "You landed on " + getGb().getCurrentPlayer().getCurrentPosition() + " which is the parking square, and it does nothing"; }

    }
}