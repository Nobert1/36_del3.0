package Models;

import Controllers.GameBoard;

public class Logic {


    /** Checks for in Jail, setup so it's ready for the chancecard.
     * - comment by Gustav
     * Have added messages and that it costs 1 dollar to get out of jail
     * - Alex
     */

    public void checkforInJail() {
        if (getGb().getCurrentPlayer().getInJail() == true && getGb().getCurrentPlayer().getJailCard() == true) {
            getGb().gui.showMessage("You use your get out jail free card and are released next turn!");
            getGb().getCurrentPlayer().setJailCard(false);
        }
        else if (getGb().getCurrentPlayer().getInJail() == true) {
            getGb().getCurrentPlayer().setInJail(false);
            getGb().gui.showMessage("You were jailed for attempting to apply to RUC, you are being skipped this turn as a punishment\n" +
                    "You will be released next turn and it will cost you 1 dollar.");
            getGb().getCurrentPlayer().getAccount().withdraw(1);
            getPlayerTurn();
        }
    }

    public GameBoard getGb(){
        return GameBoard.getInstance();
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
        for (int j = 0; j < getGb().getPlayerArray().length; j++) {
            if (getGb().getPlayerArray()[j].getBroke() == true) {
                Loser = getGb().getPlayerArray()[j].getName();
                loserfound = true;
            }
            if (loserfound == true) {
                for (int i = 1; i < getGb().getPlayerArray().length; i++) {
                    if (getGb().getPlayerArray()[i].getAccount().getBalance() > getGb().getPlayerArray()[i - 1].getAccount().getBalance()) {
                        Winner = getGb().getPlayerArray()[i].getName();
                    } else Winner = getGb().getPlayerArray()[0].getName();
                }

                getGb().gui.showMessage("Ladies and gentlemen... " + Loser + " is broke! therefore the winner is " + Winner + "! HUGE CONGRATS PERSON");

                // Closes GUI then terminates the program.

                getGb().gui.close();
                System.exit(0);

            } } }


    /** Method to check if the currentPlayer passed start
     * - comment by Gustav
     * Updated so it shows message and does it if you pass or are on go.
     * - Alex
     */
    public void checkforStart() {
        if (getGb().getCurrentPlayer().getCurrentPosition() > 23) {
            getGb().getCurrentPlayer().getAccount().deposit(2);
            getGb().getCurrentPlayer().setCurrentPosition(getGb().getCurrentPlayer().getCurrentPosition() % 24);
            if(getGb().getCurrentPlayer().getCurrentPosition() == 0){
                getGb().gui.showMessage("You are landing on go. Collect 2 dollars.");
            } else {
                getGb().gui.showMessage("You are passing go. Collect 2 dollars.");
            }
        }
    }
    public void getPlayerTurn() {
        if (getGb().getCurrentPlayer() == getGb().getPlayerArray()[0]) {
            getGb().setCurrentPlayer(getGb().getPlayerArray()[1]);
            getGb().setCurrentGUIPlayer(getGb().getGuiArray()[1]);



        } else if (getGb().getCurrentPlayer() == getGb().getPlayerArray()[1]) {
            getGb().setCurrentPlayer(getGb().getPlayerArray()[2 % getGb().getPlayerArray().length]);
            getGb().setCurrentGUIPlayer(getGb().getGuiArray()[2 % getGb().getGuiArray().length]);



        } else if (getGb().getCurrentPlayer() == getGb().getPlayerArray()[2]) {
            getGb().setCurrentPlayer(getGb().getPlayerArray()[3 % getGb().getPlayerArray().length]);
            getGb().setCurrentGUIPlayer(getGb().getGuiArray()[3 % getGb().getGuiArray().length]);


        } else if (getGb().getCurrentPlayer() == getGb().getPlayerArray()[3]) {
            getGb().setCurrentPlayer(getGb().getPlayerArray()[0]);
            getGb().setCurrentGUIPlayer(getGb().getGuiArray()[0]);
        }
        getGb().playerTurn();
    }

    /** Calls polymorphic methods based on the Square
     * - comment by Gustav
     */

    public void applySquareLogic() {

        int i = getGb().getCurrentPlayer().getCurrentPosition();

        getGb().getFI().getField(i).OutputToGUI();
        getGb().getFI().getField(i).FieldFunctionality();

        CheckforBroke();


    }

}
