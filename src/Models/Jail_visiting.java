package Models;
import Controllers.GameBoard;

/**
 * Simple class, it actually doesn't do anything unless we can find a way to get the release from jail in here. That is probably
 * not possible to definitly subject for deletion.
 * - comment by Gustav
 */


public class Jail_visiting extends Fields {

    private int position;
    private int jailtime;
    private String name;
    private GameBoard gb = GameBoard.getInstance();
    private Player player = gb.getPlayer();


    public Jail_visiting(int position, String name, int jailtime) {
        super(position, name);

        this.position = position;
        this.jailtime = jailtime;
        this.name = name;

    }

    public void gottojail() {

       // this.player position

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

            return "You landed on number " + getPosition() + "Luckily you are just visiting";
    }

}
