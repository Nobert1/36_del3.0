package Models;

import Controllers.GameBoard;
import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Field;
import gui_main.GUI;

import java.lang.reflect.Field;

public abstract class Fields  {

    protected int position;
    protected String name;
    private Fields[] fields;
    //private Fields[] FIELDINSTANS = GameBoard.getFIELDINSTANS();



    public Fields(int position, String name) {

        this.position = position;
        this.name = name;

    }

    public Fields() {

        makeFields();

        }


    public Fields[] getFields() {
        return fields;
    }


    public String toString() {
        String o = "";
        for (int i = 0; i < fields.length; i++) {
            o += fields[i].getName() + "\n";
        }
        return o;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


    public abstract void FieldFunctionality();

    public abstract void OutputToGUI();



    public Fields[] makeFields() {

        fields = new Fields[24];
        fields[0] = new Start(0, "start");
        fields[1] = new Properties(1, "GATEKJØKKENET \n BURGERBAREN", 1, "BROWN");
        fields[2] = new Properties(2, "Pizzahuset \n Pizzeriaet", 1, "BROWN");
        fields[3] = new Chance_Square(3, "Chancen");
        fields[4] = new Properties(4, "Godtebutikken \n Slikbutikken", 1, "Lightblue");
        fields[5] = new Properties(5, "ISKIOSKEN \n ISKIOSKEN", 1, "Lightblue");
        fields[6] = new Jail_visiting(6, "Jail", 1);
        fields[7] = new Properties(7, "Museet \n Museet", 2, "PINK");
        fields[8] = new Properties(8, "Bibloteket \n Bibloteket", 2, "PINK");
        fields[9] = new Chance_Square(9, "Try your luck");
        fields[10] = new Properties(10, "Rullebretparken \n Skateparken", 2, "Orange");
        fields[11] = new Properties(11, "Svømmebassenget \n Swimmingpoolen", 2, "Orange");
        fields[12] = new Start(12, "Parkering");
        fields[13] = new Properties(13, "Spillehallen \n Spillehallen", 3, "red");
        fields[14] = new Properties(14, "Kinoen \n Biografen", 3, "red");
        fields[15] = new Chance_Square(15, "Chancesquare");
        fields[16] = new Properties(16, "Leketøjsbutikken \n Legetøjsbutikken", 3, "YElLOW");
        fields[17] = new Properties(17, "Dyrebutikken \n Dyerhandlen", 3, "YElLOW");
        fields[18] = new Go_to_jail(18, "Go to prison", 1);
        fields[19] = new Properties(19, "Bowlinghallen \n Bowlinghallen", 4, "GREEN");
        fields[20] = new Properties(20, "Zoologisk have \n Zoo", 4, "GREEN");
        fields[21] = new Chance_Square(21, "Try your luck");
        fields[22] = new Properties(22, "Vannlandet  \n Vandlandet", 4, "DARK BLUE");
        fields[23] = new Properties(23, "Strandpromenaden  \n Strandpromenaden", 4, "DARK BLUE");
        return fields;

    }


    public void setFields(Fields[] fields) {
        this.fields = fields;
    }
}



