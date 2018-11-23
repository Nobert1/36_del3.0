package Models;

import gui_main.GUI;

import java.lang.reflect.Field;

public abstract class Fields  {

    protected int position;
    protected String name;
    protected static Fields[] fields;


    public Fields(int position, String name) {

        this.position = position;
        this.name = name;
        makeFields();


    }

    public static Fields[] getFields () {
        return fields;
    }

    public String toString() {

        return super.toString();

    }
    public abstract void FieldFunctionality();{


    }

    public int getPosition() {
        return position;
    }

    public void makeFields() {

        int i = 0;
        fields[i++] = new Start(0, "start");
        fields[i++] = new Properties(1, "GATEKJØKKENET \n BURGERBAREN", 1, "BROWN");
        fields[i++] = new Properties(2, "Pizzahuset \n Pizzeriaet", 1,  "BROWN");
        fields[i++] = new Chance_Square(3, "Chancen");
        fields[i++] = new Properties(4, "Godtebutikken \n Slikbutikken", 1,  "Lightblue");
        fields[i++] = new Properties(5, "ISKIOSKEN \n ISKIOSKEN", 1,  "Lightblue");
        fields[i++] = new Jail_visiting(6, "Jail", 1);
        fields[i++] = new Properties(7, "Museet \n Museet", 2,  "PINK");
        fields[i++] = new Properties(8, "Bibloteket \n Bibloteket", 2,  "PINK");
        fields[i++] = new Chance_Square(9, "Try your luck");
        fields[i++] = new Properties(10, "Rullebretparken \n Skateparken", 2,  "Orange");
        fields[i++] = new Properties(11, "Svømmebassenget \n Swimmingpoolen", 2,  "Orange");
        fields[i++] = new Start(12, "Parkering");
        fields[i++] = new Properties(13, "Spillehallen \n Spillehallen", 3,  "red");
        fields[i++] = new Properties(14, "Kinoen \n Biografen", 3,  "red");
        fields[i++] = new Chance_Square(15, "Chancesquare");
        fields[i++] = new Properties(16, "Leketøjsbutikken \n Legetøjsbutikken", 3,  "YElLOW");
        fields[i++] = new Properties(17, "Dyrebutikken \n Dyerhandlen", 3,  "YElLOW");
        fields[i++] = new Go_to_jail(18, "Go to prison", 1);
        fields[i++] = new Properties(19, "Bowlinghallen \n Bowlinghallen", 4,  "GREEN");
        fields[i++] = new Properties(20, "Zoologisk have \n Zoo", 4,  "GREEN");
        fields[i++] = new Chance_Square(21, "Try your luck");
        fields[i++] = new Properties(22, "Vannlandet  \n Vandlandet", 4,  "DARK BLUE");
        fields[i++] = new Properties(23, "Strandpromenaden  \n Strandpromenaden", 4, "DARK BLUE");
    }



    public abstract void OutputToGUI();


    }


