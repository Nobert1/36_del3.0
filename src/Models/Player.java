package Models;

import Controllers.GameBoard;

/**
 * Player class with the logic behind the GUI.
 */

public class Player {

    private String name;
    private BankAccount account;
    private boolean inJail;
    private boolean isBroke;
    private int currentPosition;
    private boolean JailCard;
    private boolean payNothing;


    public Player(String name) {

        this.name = name;
        this.account = new BankAccount(24-2*getGb().getPlayers());
        this.inJail = false;
        this.isBroke = false;
        this.currentPosition = 0;
        this.JailCard = false;
    }

    public GameBoard getGb(){
        return GameBoard.getInstance();
    }

    public String getName() {
        return this.name;
    }

    public BankAccount getAccount() {
        return account;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public boolean getInJail() {
        return this.inJail;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public void setBroke(boolean broke) {
        isBroke = broke;
    }

    public boolean getBroke() {
        return this.isBroke;
    }

    public void setJailCard(boolean jailCard) { JailCard = jailCard; }

    public boolean getJailCard() {
        return this.JailCard;
    }

    public boolean isPayNothing() {
        return payNothing;
    }

    public void setPayNothing(boolean payNothing) {
        this.payNothing = payNothing;
    }
}
