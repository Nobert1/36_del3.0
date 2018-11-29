package Models.Fields;


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



    public void setFields(Fields[] fields) {
        this.fields = fields;
    }
}



