package Wrappers;

import gui_fields.*;

import java.awt.*;

public class FieldFactory_Modified {

    public FieldFactory_Modified() {
}
    public static GUI_Field[] makeFieldsJuniorMatador() {
        GUI_Field[] fields = new GUI_Field[24];
        int i = 0;
        fields[i++] = new GUI_Start("Start", "Recive M2", "Recive M2 \n when you pass start", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street("BURGERBAREN", "M1", "BURGERBAREN", "Leje:  1", new Color(90, 40, 0), Color.BLACK);
        fields[i++] = new GUI_Street("PIZZERIAET", "M1", "PIZZARIAET", "Leje:  1", new Color(90, 40, 0), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Try your luck", "Take a chancecard", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("SLIKBUTIKKEN", "M1", "SLIKBUTIKKEN", "Leje:  1", new Color(75, 155, 225), Color.BLACK);
        fields[i++] = new GUI_Street("ISKIOSKEN", "M1", "ISKIOSKEN", "Leje:  1", new Color(75, 155, 225), Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Visiting Prison", " Visiting prison", "Visting Prison", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("MUSEET", "M2", "MUSEET", "Leje:  1", new Color(200, 100, 225), Color.BLACK);
        fields[i++] = new GUI_Street("BIBLOTEKET", "M2", "BIBLOTEKET", "Leje:  1", new Color(200, 100, 225), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Try your luck", "Take a chancecard", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("SKATEPARKEN", "M2", "SKATEPARKEN", "Leje:  1", new Color(250, 150, 0), Color.BLACK);
        fields[i++] = new GUI_Street("SVØMMEBASSENGET", "M2", "SVØMMEBASSENGET", "Leje:  1", new Color(250, 150, 0), Color.BLACK);
        fields[i++] = new GUI_Refuge("default", "Parkering", "PARKERING", "Take a break", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("SPILLEHALLEN", "M3", "SPILLEHALLEN", "Leje:  1", new Color(250, 1, 0), Color.BLACK);
        fields[i++] = new GUI_Street("KINOEN", "M3", "KINOEN", "Leje:  1", new Color(250, 1, 0), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Try your luck", "Take a chancecard", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("LEGETØJSBUTIKKEN", "M3", "LEGETØJSBUTIKKEN", "Leje:  1", new Color(250, 250, 0), Color.BLACK);
        fields[i++] = new GUI_Street("DYREHANDLEN", "M3", "DYREHANDLEN", "Leje:  1", new Color(250, 250, 0), Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Go to prison", "Go to prison", "You are put in jail \nWait a turn to get out", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("BOWLINGHALLEN", "M4", "BOWLINGHALLEN", "Leje:  1", new Color(30, 100, 0), Color.BLACK);
        fields[i++] = new GUI_Street(" ZOO", "M4", "ZOO", "Leje:  1", new Color(30, 100, 0), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Try your luck", "Take a chancecard", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("VANDLANDET", "M5", "VANDLANDET", "Leje:  1", new Color(10, 1, 225), Color.BLACK);
        fields[i++] = new GUI_Street("STRANDPROMENADEN", "M5", "STRANDPROMENADEN", "Leje:  1", new Color(10, 1, 225), Color.BLACK);
        return fields;
    }
    }



