package Desktop_GUI.GUI.gui_tests;

import Desktop_GUI.GUI.gui_main.GUI;

public class Non_Static_Test {
    
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        GUI gui = new GUI();
        
        gui = new GUI();
        
    }
    
}
