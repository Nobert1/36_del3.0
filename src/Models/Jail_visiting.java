package Models;

import Controllers.GameBoard;

public class Jail_visiting extends Fields {

    Models.Player player = new Player("");

    private int position;
    private int jailtime;
    private String name;
    private GameBoard gb = GameBoard.getInstance();


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
