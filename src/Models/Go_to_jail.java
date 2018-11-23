package Models;
import Controllers.GameBoard;
import gui_fields.GUI_Player;

public class Go_to_jail extends Fields {


    private GameBoard gb = GameBoard.getInstance();
    int jailtime;


    public Go_to_jail(int position, String name, int jailtime) {
        super(position, name);
        this.jailtime = jailtime;
    }

    public void setJailtime() {
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
        return "You landed on number " + getPosition() + "You are going to jail :/";
    }
}
