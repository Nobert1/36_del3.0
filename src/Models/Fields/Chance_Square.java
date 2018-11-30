package Models.Fields;
import Controllers.GameBoard;

/**
 * Class for the Chance Squares
 */
public class Chance_Square extends Fields {


    public GameBoard getGb(){
        return GameBoard.getInstance();
    }


    public Chance_Square(int position, String name) {
        super(position, name);
    }

    @Override
    public void FieldFunctionality() {

        getGb().getCD().drawCard();
        getGb().getGui().displayChanceCard(getGb().getCD().getIndex(15).getDescription());
        getGb().getCD().UseChancecard();

    }

    @Override
    public void OutputToGUI(){
        getGb().getGui().showMessage(toString());


    }

    @Override
    public String toString() {
        return "You landed on field " + getPosition() + " which is a chance square, you are now going to draw a chance card";
    }

    @Override
    public int getPosition() {
        return super.getPosition();
    }
}
