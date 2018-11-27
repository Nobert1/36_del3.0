package Controllers;

import Models.*;
import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

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
    private GUI_FieldFactory fc = new GUI_FieldFactory();
    public GUI gui;
    private Dice die;
    private int players;
    public GUI_Player[] guiArray;
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
        players = setPlayers();
        guiArray = new GUI_Player[players];
        playerArray = new Player[players];

    }


    public void startGame() {

        setPlayerNames();
        playerTurn();
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
            gui.getFields()[0].setCar(guiArray[i], true);
            gui.addPlayer(spiller);
            arr1 = new String[arrTemp.length];
            for(int z = 0; z < arrTemp.length; z++){
                arr1[z] = arrTemp[z];
            }

        }
        currentGUIPlayer = guiArray[0];
        currentPlayer = playerArray[0];
    }

    /** Initalizes the players turn
     * - comment by Gustav
     */

    public void playerTurn() {



        gui.showMessage("It is " + currentPlayer.getName() + "'s turn. Press enter to roll the dice.");
        die.roll();
        gui.setDie(die.getValue());
        movePlayer();

    }

    /** Simple move function that also checks if the currentPlayer is jailed, can perhaps be made more sophisticated
     * - comment by Gustav
     */
    public void movePlayer() {

        gui.getFields()[currentPlayer.getCurrentPosition()].setCar(currentGUIPlayer, false);
        currentPlayer.setCurrentPosition(currentPlayer.getCurrentPosition() + die.getValue());
        checkforStart();
        gui.getFields()[currentPlayer.getCurrentPosition()].setCar(currentGUIPlayer, true);
        applySquareLogic();

    }

    /** Calls polymorphic methods based on the Square
     * - comment by Gustav
     */
    public void applySquareLogic() {

        int i = currentPlayer.getCurrentPosition();

        FI.getField(i).OutputToGUI();
        FI.getField(i).FieldFunctionality();


        updatePlayerBalances();
        CheckforBroke();
        checkforInJail();
        getPlayerTurn();

    }

    /** Sets the current currentPlayer object to a new currentPlayer, so we can switch turns
     * - comment by Gustav
     */
    public void getPlayerTurn() {
        if (currentGUIPlayer == guiArray[0]) {
            currentGUIPlayer = guiArray[1];
            currentPlayer = playerArray[1];

        } else if (currentGUIPlayer == guiArray[1]) {
            currentGUIPlayer = guiArray[2 % guiArray.length];
            currentPlayer = playerArray[2 % playerArray.length];

        } else if (currentGUIPlayer == guiArray[2]) {
            currentGUIPlayer = guiArray[3 % guiArray.length];
            currentPlayer = playerArray[3 % playerArray.length];

        } else if (currentGUIPlayer == guiArray[3]) {
            currentGUIPlayer = guiArray[0];
            currentPlayer = playerArray[0];
        }
        playerTurn();
    }

    /** Method to sync the balance in the GUI with the actual players balance.
     * - comment by Gustav
     */
    public void updatePlayerBalances() {

        for (int i = 0; i < playerArray.length; i++)
            guiArray[i].setBalance(playerArray[i].getAccount().getBalance());
    }

    /** Method to check if the currentPlayer passed start
     * - comment by Gustav
     * Updated so it shows message and does it if you pass or are on go.
     * - Alex
     */
    public void checkforStart() {
        if (currentPlayer.getCurrentPosition() > 23) {
            currentPlayer.getAccount().deposit(2);
            currentPlayer.setCurrentPosition(currentPlayer.getCurrentPosition() % 24);
            if(currentPlayer.getCurrentPosition() == 0){
                gui.showMessage("You are landing on go. Collect 2 dollars.");
            } else {
                gui.showMessage("You are passing go. Collect 2 dollars.");
            }
        }
    }
    /** Looks for a winner.
     * - comment by Gustav
     * Have added that if currentPlayer 1 is the winner it can find his name
     * - Alex
     */
    public void CheckforBroke() {
        String Winner = "";
        String Loser = "";
        Boolean loserfound = false;
        for (int j = 0; j < playerArray.length; j++) {
            if (playerArray[j].getBroke() == true) {
                Loser = playerArray[j].getName();
                loserfound = true;
            }
            if (loserfound == true) {
                for (int i = 1; i < playerArray.length; i++) {
                    if (playerArray[i].getAccount().getBalance() > playerArray[i - 1].getAccount().getBalance()) {
                        Winner = playerArray[i].getName();
                    } else Winner = playerArray[0].getName();
                }

                gui.showMessage("Ladies and gentlemen... " + Loser + " is broke! therefore the winner is " + Winner + "! HUGE CONGRATS PERSON");

                // Closes GUI then terminates the program.

                gui.close();
                System.exit(0);

                } } }

    /** Checks for in Jail, setup so it's ready for the chancecard.
     * - comment by Gustav
     * Have added messages and that it costs 1 dollar to get out of jail
     * - Alex
     */
    public void checkforInJail() {
        if (currentPlayer.getInJail() == true && currentPlayer.getJailCard() == true) {
            gui.showMessage("You use your get out jail free card and are released next turn!");
            currentPlayer.setJailCard(false);
        }
        else if (currentPlayer.getInJail() == true) {
            currentPlayer.setInJail(false);
            gui.showMessage("You were jailed for attempting to apply to RUC, you are being skipped this turn as a punishment\n" +
                                  "You will be released next turn and it will cost you 1 dollar.");
            getCurrentPlayer().getAccount().withdraw(1);
            getPlayerTurn();
        }
    }

    /**
     * Getters for the other classes to use when they refer to the board.
     * - comment by Gustav
     */
    public GUI_Player getCurrentGUIPlayer() { return currentGUIPlayer; }

    public Player getCurrentPlayer() { return currentPlayer; }

    public int getPlayers() { return players; }

    public Board getFI() { return FI; }

    public static GameBoard getInstance() { return Instans; }

    public GUI_FieldFactory getFc() {
        return fc;
    }

    public GUI_Player[] getGuiArray() { return guiArray; }
}



