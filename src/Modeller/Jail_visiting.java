package Modeller;

public class Jail_visiting extends Modeller.Squares {

    Modeller.Player player = new Player("");

    private int position;
    private int jailtime;
    private String name;

    public Jail_visiting(int position, String name, int jailtime) {
        super(position, name);

        this.position = position;
        this.jailtime = jailtime;
        this.name = name;

    }

    public void gottojail() {

       // this.player position

    }

}
