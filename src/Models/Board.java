
package Models;

/**
 * Only way i could figure out how to pass a board instance to the Gameboard class was by making this class and making the call static.
 * Took me three fucking hours so no messing around.
 * - comment by Gustav
 */

public class Board {

    private Fields[] fields;

    public Board() {

        fields = new Fields[24];
        fields[0] = new FunctionlessSquare(0, "start");
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
        fields[12] = new FunctionlessSquare(12, "Parkering");
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

    }


    public Fields getField(int position) {
        return fields[position];
    }

    public String toString() {
        String o = "";
        for (int i = 0; i < fields.length; i++) {
            o += fields[i].getName() + "\n";
        }
        return o;
    }
}




