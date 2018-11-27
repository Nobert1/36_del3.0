package gui_codebehind;


import java.awt.Color;
import gui_fields.GUI_Brewery;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Jail;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Shipping;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;
import gui_fields.GUI_Tax;
import Controllers.GameBoard;

/**
 * Creates all the fields
 * @author Ronnie
 */
public final class GUI_FieldFactory {

    public GUI_FieldFactory() {

    }
    public static GUI_Field[] makeFields() {
        GUI_Field[] fields = new GUI_Field[40];
        int i = 0;
        fields[i++] = new GUI_Start("FunctionlessSquare", "Modtag: 200", "Modtag kr. 200,-\nnår de passerer start", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street("Rødovrevej", "Pris:  60", "Rødovrevej", "Leje:  20", new Color(200, 125, 225), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("Hvidovrevej", "Pris:  60", "Hvidovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK);
        fields[i++] = new GUI_Tax("Betal\nindkomst-\nskat", "10% el. 200", "Betal indkomstskat\n10% eller kr. 200,-", Color.GRAY, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "Øresund", "Pris:  200", "Øresundsredderiet", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Roskildevej", "Pris:  100", "Roskildevej", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("Valby\nLanggade", "Pris:  100", "Valby Langgade", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[i++] = new GUI_Street("Allégade", "Pris:  120", "Allégade", "Leje:  45", new Color(255, 135, 120), Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("Frederiks-\nberg Allé", "Pris:  140", "Frederiksberg Allé", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Brewery("default", "Tuborg", "Pris:  150", "Tuborg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[i++] = new GUI_Street("Bülowsvej", "Pris:  140", "Bülowsvej", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Street("Gammel Kongevej", "Pris:  140", "Gammel Kongevej", "Leje:  50", new Color(102, 204, 0), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "D.F.D.S.", "Pris:  200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Bernstorffsvej", "Pris:  180", "Bernstorffsvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("Hellerupvej", "Pris:  180", "Hellerupvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Street("Strandvejen", "Pris:  180", "Strandvejen", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[i++] = new GUI_Refuge("default", "Helle", "Helle", "Ta' en pause", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Trianglen", "Pris:  220", "Trianglen", "Leje:  70", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(250, 50, 200), Color.BLACK);
        fields[i++] = new GUI_Street("Østerbro-\ngade", "Pris:  220", "Østerbrogade", "Leje:  70", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Street("Grønningen", "Pris:  240", "Grønningen", "Leje:  80", Color.RED, Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "Ø.S.", "Pris:  200", "Ø.S. redderiet", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Bredgade", "Pris:  260", "Bredgade", "Leje:  80", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Street("Kgs. Nytorv", "Pris:  260", "Kongens Nytorv", "Leje:  80", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Brewery("default", "Carlsberg", "Pris:  150", "Carlsberg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[i++] = new GUI_Street("Østergade", "Pris:  280", "Østergade", "Leje:  85", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK);
        fields[i++] = new GUI_Street("Amagertorv", "Pris:  300", "Amagertorv", "Leje:  95", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Street("Vimmel-\nskaftet", "Pris:  300", "Vimmelskaftet", "Leje:  95", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("Nygade", "Pris:  320", "Nygade", "Leje:  100", new Color(255, 255, 50), Color.BLACK);
        fields[i++] = new GUI_Shipping("default", "Bornholm", "Pris:  200", "Bornholms redderi", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[i++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[i++] = new GUI_Street("Frederiks-\nberggade", "Pris:  350", "Frederiksberggade", "Leje:  120", new Color(150, 60, 150), Color.WHITE);
        fields[i++] = new GUI_Tax("Ekstra-\nordinær\nstatsskat", "Betal 100", "Betal ekstraordinær\nstatsskat: kr. 100,-", Color.GRAY, Color.BLACK);
        fields[i++] = new GUI_Street("Rådhuspladsen", "Pris:  400", "Rådhuspladsen", "Leje:  150", new Color(150, 60, 150), Color.WHITE);
        return fields;
    }
/*
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
        fields[i++] = new GUI_Street(" STRANDPROMENADEN", "M5", "STRANDPROMENADEN", "Leje:  1", new Color(10, 1, 225), Color.BLACK);
return fields;
    }*/


}
