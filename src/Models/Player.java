package Models;

import gui_fields.GUI_Player;

public class Player {

    private String name;
    private BankAccount account;
    private boolean inJail;


    public Player(String name) {

        this.name = name;
        this.account = new BankAccount(0);
        this.inJail = false;
    }

    public String getName() {
        return this.name;
    }


    public BankAccount getAccount() {
        return account;
    }

    public void getInJail(){
        inJail = true;
    }

    public void getFree(){
        inJail = false;
    }

    public void add(String navn, int players){
        new GUI_Player(name, 24-2*players);

    }


}