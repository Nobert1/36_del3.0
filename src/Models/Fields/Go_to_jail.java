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



    int jailtime;
    private Player player = getGb().getCurrentPlayer();
    private GUI_Player currentGUIPlayer = getGb().getCurrentGUIPlayer();



    public Go_to_jail(int position, String name) {
        super(position, name);
    }

    public GameBoard getGb(){
        return GameBoard.getInstance();
    }

    @Override
    public void FieldFunctionality() {


        getGb().getGui().getFields()[18].setCar(getGb().getCurrentGUIPlayer(), false);
        getGb().getCurrentPlayer().setCurrentPosition(6);
        getGb().getCurrentGUIPlayer().setPlacement(6);
        getGb().getGui().getFields()[6].setCar(getGb().getCurrentGUIPlayer(), true);
        getGb().getCurrentPlayer().setInJail(true);


    }


    @Override
    public void OutputToGUI() {

        getGb().getGui().showMessage(toString());

    }

    @Override
    public String toString() {
        return "You landed on number " + getPosition() + "· You are going to jail :/";
    }
}

