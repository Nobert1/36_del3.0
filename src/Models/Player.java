package Models;

import gui_fields.GUI_Player;

public class Player {

    private String name;
    private BankAccount account;
    private boolean inJail;
    private boolean isBroke;
    private int currentPosition;


    public Player(String name) {

        this.name = name;
        this.account = new BankAccount(0);
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

    public int setCurrentposition(int newPosition){
        currentPosition = newPosition %  24;
        return currentPosition;
    }




}