package Models.Fields;


/**
 * The Superclass for all fields. Is abstract so we can use polymorphic methods.
 * These are toString, FieldFunctionality and OutputToGUI
 */

public abstract class Fields  {

    protected int position;
    protected String name;
    private Fields[] fields;

    public Fields(int position, String name) {

        this.position = position;
        this.name = name;

    }

    public Fields[] getFields() {
        return fields;
    }

    //toString which prints the array of fields out.
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



