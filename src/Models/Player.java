package Models;

import Controllers.GameBoard;
import gui_fields.GUI_Player;

public class Player {

    private String name;
    private BankAccount account;
    private boolean inJail;
    private boolean isBroke;
    private int currentPosition;
    private GameBoard gb = GameBoard.getInstance();



    public Player(String name) {

        this.name = name;
        this.account = new BankAccount(24-2*gb.getPlayers());
        this.inJail = false;
        this.isBroke = false;
        this.currentPosition = 0;

    }


    public String getName() {
        return this.name;
    }


    public BankAccount getAccount() {
        return account;
    }

    public void isInJail(){
        inJail = true;
    }

    public void isFree(){
        inJail = false;
    }

    public void isBroke() {
        isBroke = true;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}