package Models;

import Controllers.GameBoard;

public class Logic {


    /**
     * Logic class which contains the relevant game logic in the rules. Class is used to check if a player is
     * in jail, passed or on start or broke.
     */

    public void checkforInJail() {
        if (getGb().getCurrentPlayer().getInJail() == true && getGb().getCurrentPlayer().getJailCard() == true) {
            getGb().getGui().showMessage("You use your get out jail free card and are released next turn!");
            getGb().getCurrentPlayer().setJailCard(false);
            getGb().getCurrentPlayer().setInJail(false);
        }
        else if (getGb().getCurrentPlayer().getInJail() == true) {
            getGb().getCurrentPlayer().setInJail(false);
            getGb().getGui().showMessage(getGb().getCurrentPlayer().getName() + " you were jailed last turn, therefore" +
                    " you are being skipped this turn, 1M is also gonna be withdrawn from your account");
            getGb().getCurrentPlayer().getAccount().withdraw(1);
            getPlayerTurn();
        }
    }

    public GameBoard getGb(){
        return GameBoard.getInstance();
    }

    public void CheckforBroke() {
        Player Winner = getGb().getPlayerArray()[0];
        String Loser = "";
        Boolean loserfound = false;
        for (int j = 0; j < getGb().getPlayerArray().length; j++) {
            if (getGb().getPlayerArray()[j].getBroke() == true) {
                Loser = getGb().getPlayerArray()[j].getName();
                loserfound = true;
            }
            if (loserfound == true) {
                for (int i = 1; i < getGb().getPlayerArray().length; i++) {
                    if (getGb().getPlayerArray()[i].getAccount().getBalance() > Winner.getAccount().getBalance()) {
                        Winner = getGb().getPlayerArray()[i];
                    }
                }

                getGb().getGui().showMessage("Ladies and gentlemen... " + Loser + " is broke! Therefore the winner is " + Winner.getName() + "! HUGE CONGRATS PERSON");

                // Closes GUI then terminates the program.

                getGb().getGui().close();
                System.exit(0);

            } } }

    public void checkforStart() {
        if (getGb().getCurrentPlayer().getCurrentPosition() > 23) {
            getGb().getCurrentPlayer().getAccount().deposit(2);
            getGb().getCurrentPlayer().setCurrentPosition(getGb().getCurrentPlayer().getCurrentPosition() % 24);
            if(getGb().getCurrentPlayer().getCurrentPosition() == 0){
                getGb().getGui().showMessage("You are landing on go. Collect 2 dollars.");
            } else {
                getGb().getGui().showMessage("You are passing go. Collect 2 dollars.");
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

    }

    /**
     * Each field has the polymorphic method OutputtoGui and FieldFunctionality. This method is called once a player
     * has rolled and been moved.
     */
    public void applySquareLogic() {

        int i = getGb().getCurrentPlayer().getCurrentPosition();

        getGb().getFI().getField(i).OutputToGUI();
        getGb().getFI().getField(i).FieldFunctionality();


    }

}
