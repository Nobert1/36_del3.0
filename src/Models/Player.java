package Models;

import Controllers.GameBoard;
import gui_fields.GUI_Player;

/**
 * Player class is working very well at the moment. All of the logic GUI_Player used to have is passed on to this class.
 * GUI_Player now uses Player as it's information expert.
 * - comment by Gustav
 */

public class Player {

    private String name;
    private BankAccount account;
    private boolean inJail;
    private boolean isBroke;
    private int currentPosition;
    private GameBoard gb = GameBoard.getInstance();
    private boolean JailCard;



    public Player(String name) {

        this.name = name;
        this.account = new BankAccount(24-2*gb.getPlayers());
        this.inJail = false;
        this.isBroke = false;
        this.currentPosition = 0;
        this.JailCard = false;

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
}
