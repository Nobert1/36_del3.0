package Controllers;

import Models.*;

import Models.ChanceCardDeck;
import Models.Dice;
import Models.Fields;
import Models.Player;
import Out.gui_out;
import gui_codebehind.GUI_BoardController;
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

    private static GameBoard Instans = new GameBoard();
    public GUI gui;
    private Dice die;
    private int players;
    private GUI_Player[] guiArray;
    private Player[] playerArray;
    private GUI_Player currentPlayer;
    private ChanceCardDeck chanceCardDeck;

    public GUI_Player[] guiArray;
    private Player[] playerArray;
    private GUI_Player currentGUIPlayer;
    private Player player;
    private static final Board FIELDSINSTANS = new Board();
// Board skal være statisk ellers får vi en exception der hedder Initalization. Dvs at det board er ikke oprettet når programmet gerne
    // Vil benytte sig af det, der er muligvis et fix.

    /**
     * Creates the gameboard instance.
     * - comment by Gustav
     */
    public GameBoard() {

        this.gui = new GUI();
        this.die = new Dice();
        this.players = setPlayers();
        this.guiArray = new GUI_Player[players];
        this.playerArray = new Player[players];

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


    public void setPlayerNames() {
        for (int i = 0; i < players; i++) {
            String name = gui.getUserString("What would you like your name to be?");
            playerArray[i] = new Player(name);
            String[] arr = {"CAR", "RACECAR", "UFO", "TRACTOR"};
            String a = gui.getUserButtonPressed("Which icon would you like to have?", arr);
            String[] arr1 = {"White", "Black", "Red", "Blue"};
            String color = gui.getUserButtonPressed("Which colour would you like?", arr1);
            Color c;
            switch (color) {
                case "White":
                    c = Color.WHITE;
                    break;
                case "Black":
                    c = Color.BLACK;
                    break;
                case "Red":
                    c = Color.RED;
                    break;
                case "Blue":
                    c = Color.BLUE;
                    break;
                default:
                    c = Color.BLACK;
            }
            GUI_Car Car = new GUI_Car(c, c, GUI_Car.Type.getTypeFromString(a), GUI_Car.Pattern.DOTTED);
            GUI_Player spiller = new GUI_Player(name, 24 - 2 * players, Car, 0);
            guiArray[i] = spiller;
            gui.getFields()[0].setCar(guiArray[i], true);
            gui.addPlayer(spiller);

        }
        currentGUIPlayer = guiArray[0];
        player = playerArray[0];
    }

    /** Initalizes the players turn
     * - comment by Gustav
     */

    public void playerTurn() {


        gui.showMessage("It is " + currentGUIPlayer.getName() + "'s turn. Press enter to roll the dice.");
        gui.showMessage("It is " + currentPlayer.getName() + "'s turn. Press enter to roll the dice.");
      
        die.roll();
        gui.setDie(die.getValue());
        movePlayer();

    }

    /** Simple move function that also checks if the player is jailed, can perhaps be made more sophisticated
     * - comment by Gustav
     */
    public void movePlayer() {

        if (player.getInJail() == true) {
            player.setInJail(false);
            gui.showMessage("You were jailed for attempting to apply to RUC, you are being skipped this turn as a punishment");
        } else

            gui.getFields()[currentGUIPlayer.getPlacement()].setCar(currentGUIPlayer, false);

        player.setCurrentPosition(player.getCurrentPosition() + die.getValue());

        checkforStart();

        currentGUIPlayer.setPlacement(player.getCurrentPosition());

        gui.getFields()[currentGUIPlayer.getPlacement()].setCar(currentGUIPlayer, true);
        gui.displayChanceCard();
       


        applySquareLogic();

    }

    /** Calls polymorphic methods based on the Square
     * - comment by Gustav
     */
    public void applySquareLogic() {

        int i = currentGUIPlayer.getPlacement();

        FIELDSINSTANS.getField(i).OutputToGUI();
        FIELDSINSTANS.getField(i).FieldFunctionality();

        updatePlayerBalances();
        CheckforBroke();
        getPlayerTurn();
    }

    /** Sets the current player object to a new player, so we can switch turns
     * - comment by Gustav
     */
    public void getPlayerTurn() {
        if (currentGUIPlayer == guiArray[0]) {
            currentGUIPlayer = guiArray[1];
            player = playerArray[1];

        } else if (currentGUIPlayer == guiArray[1]) {
            currentGUIPlayer = guiArray[2 % guiArray.length];
            player = playerArray[2 % playerArray.length];

        } else if (currentGUIPlayer == guiArray[2]) {
            currentGUIPlayer = guiArray[3 % guiArray.length];
            player = playerArray[3 % playerArray.length];

        } else if (currentGUIPlayer == guiArray[3]) {
            currentGUIPlayer = guiArray[0];
            player = playerArray[0];
        }
        playerTurn();
    }


    /**
     * Getters for the other classes to use when they refer to the board.
     * - comment by Gustav
     */
    public GUI_Player getCurrentGUIPlayer() {
        return currentGUIPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayers() {
        return players;
    }

    public Board getFIELDSINSTANS() {
        return FIELDSINSTANS;
    }

    public static GameBoard getInstance() {
        return Instans;
    }

    public GUI_Player[] getGuiArray() {
        return guiArray;
    }

    /** Print statement for test purposes, probably have to be deleted.
     * - comment by Gustav
     */

    public String print() {
        String output = "";
        for (int i = 0; i < getGuiArray().length; i++) {
            output += guiArray[i].getName() + "\n";
        }
        return output;
    }

    /** Method to sync the balance in the GUI with the actual players balance.
     * - comment by Gustav
     */
    public void updatePlayerBalances() {

        for (int i = 0; i < playerArray.length; i++)
            guiArray[i].setBalance(playerArray[i].getAccount().getBalance());
    }

    /** Method to check if the player passed start
     * - comment by Gustav
     */
    public void checkforStart() {
        if (player.getCurrentPosition() > 23) {
            player.getAccount().deposit(2);
            player.setCurrentPosition(player.getCurrentPosition() % 24);
        }
    }

    /** Looks for a winner.
     * - comment by Gustav
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
                    }
                }

                gui.showMessage("Ladies and gentlemen... " + Loser + " is broke! therefore the winner is " + Winner + "! HUGE CONGRATS MAN");

                // Closes GUI then terminates the program.

                gui.close();
                System.exit(0);

            }
        }
    }
}



