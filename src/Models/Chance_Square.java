package Models;
import Controllers.GameBoard;

/**
 * Also relatively simple class. The only special thing about it is the polymorphic methods.
 * - comment by Gustav
 */
public class Chance_Square extends Fields {


    private GameBoard gb = GameBoard.getInstance();


    public Chance_Square(int position, String name) {
        super(position, name);
    }

    @Override
    public void FieldFunctionality() {
        gb.getCD().drawCard();

    }

    @Override
    public void OutputToGUI(){
        gb.gui.showMessage(toString());


    }

    @Override
    public String toString() {
        return "You landed on field " + getPosition() + " wich is a change square, you are now going to draw a chance card";
    }

    @Override
    public int getPosition() {
        return super.getPosition();
    }
}
