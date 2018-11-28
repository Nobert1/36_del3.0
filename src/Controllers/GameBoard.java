package Controllers;

import Models.*;
import View.GUI_Handler;
import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import Wrappers.Board;

import java.awt.*;

/**
 * Method that creates the gameboard and everything in it. It is static because that makes it referable in the other classes.
 * Since it's static it takes no arguments other than those from the program and is there always the same, and referable
 * by using simple getters and setters. The gameboard then contains objects from all the classes.
 *
 * I don't like having the Gameboard instans being final, we don't know enough about final.
 * I don't like it being static either but i think it has too be.
 *
 * It is very possible we can do something to get the code more sophisticated by splitting it up in respect to GRASP patterns.
 * Splitting up the GUI controller and the gameboard should be the first thing. Make GameBoard a controller and then be the
 * information Expert for GUI since it will contain all the logic.
 *
 * - comment by Gustav
 */
public class GameBoard {

    private static final GameBoard Instans = new GameBoard();
    private static Board FI = new Board();
    private GUI_Handler handler = new GUI_Handler();
    private static ChanceCardDeck CD;
    private GUI_FieldFactory fc = new GUI_FieldFactory();
    private Logic logic = new Logic();
    public GUI gui;
    private Dice die;
    private int players;
    private GUI_Player[] guiArray;
    private Player[] playerArray;
    private GUI_Player currentGUIPlayer;
    private Player currentPlayer;

// Board skal være statisk ellers får vi en exception der hedder Initalization. Dvs at det board er ikke oprettet når programmet gerne
    // Vil benytte sig af det, der er muligvis et fix.




    /**
     * Creates the gameboard instance.
     * - comment by Gustav
     */
    public GameBoard() {
        gui = new GUI();
        die = new Dice();
        players = setPlayers(); // Is NOT a setter :))
        guiArray = new GUI_Player[players];
        playerArray = new Player[players];
        CD = new ChanceCardDeck(gui);
    }


    public void startGame() {

        setPlayerNames();
        handler.setupBoard();
        movePlayer();

    }

    /** Initalizes the players turn
     * - comment by Gustav
     */

    public void playerTurn() {

        gui.showMessage("It is " + currentPlayer.getName() + "'s turn. Press enter to roll the dice.");
        die.roll();
        handler.setDice();

    }

    /** Simple move function that also checks if the currentPlayer is jailed, can perhaps be made more sophisticated
     * - comment by Gustav
     */

    public void movePlayer() {

        logic.checkforInJail();
        playerTurn();
        currentPlayer.setCurrentPosition(currentPlayer.getCurrentPosition() + die.getValue());
        logic.checkforStart();
        handler.UpdateBoard();
        logic.applySquareLogic();
        handler.UpdateBoard();
        logic.CheckforBroke();
        logic.getPlayerTurn();
        movePlayer();


    }

    /** Two methods to set up the game.
     * - comment by Gustav
     *
     */
    public int setPlayers() {
        while (true) {
            players = gui.getUserInteger(" How many players? Max 4 players ");
            if (players > 1 && players < 5) {
                break;
            } else {
                gui.showMessage("Not a valid number");
            }
        }

        return players;
    }

    /**
     * Have updated method so that it removes colour possibilities after being chosen by anther currentPlayer
     * -Alex
     */

    public void setPlayerNames() {
        String[] arr = {"CAR", "RACECAR", "UFO", "TRACTOR"};
        String[] arr1 = {"White", "Black", "Red", "Blue"};
        for (int i = 0; i < players; i++) {
            String name = gui.getUserString("What would you like your name to be?");
            playerArray[i] = new Player(name);
            String a = gui.getUserButtonPressed("Which icon would you like to have?", arr);
            String color = gui.getUserButtonPressed("Which colour would you like?", arr1);
            Color c;
            String[] arrTemp = new String[arr1.length-1];

            switch (color) {
                case "White":
                    c = Color.WHITE;
                    int z = 0;
                    for(int j = 0; j <arr1.length; j++){
                        if(arr1[j] != "White"){
                            arrTemp[z] = arr1[j];
                            z++;
                        }
                    }
                    break;
                case "Black":
                    c = Color.BLACK;
                    int z1 = 0;
                    for(int k = 0; k <arr1.length; k++){
                        if(arr1[k] != "Black"){
                            arrTemp[z1] = arr1[k];
                            z1++;
                        }
                    }
                    break;
                case "Red":
                    c = Color.RED;
                    int z2 = 0;
                    for(int l = 0; l <arr1.length; l++){
                        if(arr1[l] != "Red"){
                            arrTemp[z2] = arr1[l];
                            z2++;
                        }
                    }
                    break;
                case "Blue":
                    c = Color.BLUE;
                    int z3 = 0;
                    for(int m = 0; m <arr1.length; m++){
                        if(arr1[m] != "Blue"){
                            arrTemp[z3] = arr1[m];
                            z3++;
                        }
                    }
                    break;
                default:
                    c = Color.BLACK;
                    break;
            }

            GUI_Car Car = new GUI_Car(c, c, GUI_Car.Type.getTypeFromString(a), GUI_Car.Pattern.DOTTED);
            GUI_Player spiller = new GUI_Player(name, 24 - 2 * players, Car, 0);
            guiArray[i] = spiller;

            arr1 = new String[arrTemp.length];
            for(int z = 0; z < arrTemp.length; z++){
                arr1[z] = arrTemp[z];
                gui.getFields()[0].setCar(spiller, true);
            }

        }
        currentGUIPlayer = guiArray[0];
        currentPlayer = playerArray[0];

    }



    /**
     * Getters for the other classes to use when they refer to the board.
     * - comment by Gustav
     */
    public static ChanceCardDeck getCD() { return CD; }

    public static void setCD(ChanceCardDeck CD) { GameBoard.CD = CD; }

    public GUI_Player getCurrentGUIPlayer() { return currentGUIPlayer; }

    public Player getCurrentPlayer() { return currentPlayer; }

    public int getPlayers() { return players; }

    public Board getFI() { return FI; }

    public static GameBoard getInstance() { return Instans; }

    public GUI_FieldFactory getFc() { return fc; }

    public GUI_Player[] getGuiArray() { return guiArray; }

    public void setCurrentPlayer(Player currentPlayer) { this.currentPlayer = currentPlayer; }

    public Player[] getPlayerArray() { return playerArray; }

    public GUI_Handler getHandler() { return handler; }

    public Logic getLogic() { return logic; }

    public void setCurrentGUIPlayer(GUI_Player currentGUIPlayer) { this.currentGUIPlayer = currentGUIPlayer; }

    public Dice getDie() { return die; }
}



