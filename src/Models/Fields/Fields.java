package Models.Fields;


import Models.Properties;

/**
 * Currently abstract and working as nice as it feels to wipe your ass with silk.
 * The to String method is probably not needed and perhaps the getFields method, since they are actually rarely used.
 * They are actually only used in the method that tries to double the rent, and that is not really working to hot.
 * - comment by Gustav
 */

public abstract class Fields  {

    protected int position;
    protected String name;
    private Fields[] fields;
    //private Fields[] FIELDINSTANS = GameBoard.getFIELDINSTANS();

    public Fields(int position, String name) {

        this.position = position;
        this.name = name;

    }

    public Fields[] getFields() {
        return fields;
    }

    @Override
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
        fields[0] = new FunctionlessSquare(0, "start");
        fields[1] = new Properties(1, "GATEKJØKKENET \n BURGERBAREN", 1, 1);
        fields[2] = new Properties(2, "Pizzahuset \n Pizzariaet", 1, 2);
        fields[3] = new Chance_Square(3, "Chancen");
        fields[4] = new Properties(4, "Godtebutikken \n Slikbutikken", 1, 2);
        fields[5] = new Properties(5, "ISKIOSKEN \n ISKIOSKEN", 1, 2);
        fields[6] = new FunctionlessSquare(6, "Jail");
        fields[7] = new Properties(7, "Museet \n Museet", 2, 3);
        fields[8] = new Properties(8, "Bibloteket \n Bibloteket", 2, 3);
        fields[9] = new Chance_Square(9, "Try your luck");
        fields[10] = new Properties(10, "Rullebretparken \n Skateparken", 2, 4);
        fields[11] = new Properties(11, "Svømmebassenget \n Swimmingpoolen", 2, 4);
        fields[12] = new FunctionlessSquare(12, "Parkering");
        fields[13] = new Properties(13, "Spillehallen \n Spillehallen", 3, 5);
        fields[14] = new Properties(14, "Kinoen \n Biografen", 3, 5);
        fields[15] = new Chance_Square(15, "Chancesquare");
        fields[16] = new Properties(16, "Leketøjsbutikken \n Legetøjsbutikken", 3, 6);
        fields[17] = new Properties(17, "Dyrebutikken \n Dyerhandlen", 3, 6);
        fields[18] = new FunctionlessSquare(18, "Go to prison");
        fields[19] = new Properties(19, "Bowlinghallen \n Bowlinghallen", 4, 7);
        fields[20] = new Properties(20, "Zoologisk have \n Zoo", 4, 7);
        fields[21] = new Chance_Square(21, "Try your luck");
        fields[22] = new Properties(22, "Vannlandet  \n Vandlandet", 4, 8);
        fields[23] = new Properties(23, "Strandpromenaden  \n Strandpromenaden", 4, 8);
        return fields;

    }

    public void setFields(Fields[] fields) {
        this.fields = fields;
    }
}



