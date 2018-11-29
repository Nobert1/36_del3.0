package Models.Fields;
import Controllers.GameBoard;
import Models.Fields.Fields;
import Models.Player;
import gui_fields.GUI_Player;

/**
 * Very simple class since it only takes the attributes from Field. It is it's own class because it has a unique polymorphic call.
 * Currently having some problems with actually jailling people, seems like Java is a free language.
 * - comment by Gustav
 */
public class Go_to_jail extends Fields {


    private GameBoard gb = GameBoard.getInstance();
    int jailtime;
    private Player player = gb.getCurrentPlayer();
    private GUI_Player currentGUIPlayer = gb.getCurrentGUIPlayer();



    public Go_to_jail(int position, String name) {
        super(position, name);
    }


    @Override
    public void FieldFunctionality() {


        gb.getGui().getFields()[18].setCar(gb.getCurrentGUIPlayer(), false);
        gb.getCurrentPlayer().setCurrentPosition(6);
        gb.getCurrentGUIPlayer().setPlacement(6);
        gb.getGui().getFields()[6].setCar(gb.getCurrentGUIPlayer(), true);
        gb.getCurrentPlayer().setInJail(true);


    }


    @Override
    public void OutputToGUI() {

        gb.getGui().showMessage(toString());

    }

    @Override
    public String toString() {
        return "You landed on number " + getPosition() + "· You are going to jail :/";
    }
}
