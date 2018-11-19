package Desktop_GUI.GUI.gui_tests;

import Desktop_GUI.GUI.gui_main.GUI;

public class InputTest {

    public static void main(String[] args) {
        GUI gui = new GUI();
        String res = gui.getUserString("TEST");
        System.out.println("::-->"+res);
        
        int resi = gui.getUserInteger("TEST");
        System.out.println("||-->"+resi);
    }
}
