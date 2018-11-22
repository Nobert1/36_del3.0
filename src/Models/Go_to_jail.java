package Models;
import gui_fields.GUI_Player;

public class Go_to_jail extends Fields {

    int jailtime;
    public Go_to_jail(int position, String name, int jailtime) {
        super(position, name);
        this.jailtime = jailtime;
    }

    public void setJailtime() {
    }

    @Override
    public void FieldFunctionality() {

    }
}
