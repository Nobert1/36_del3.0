package Models;

import Controllers.GameBoard;

public class BankAccount {

    private int balance;
    private GameBoard gb = GameBoard.getInstance();
    // Constructor, for a simple class

    public BankAccount(int balance) {

        this.balance = balance;

    }


    // Method for depositing money
    public int deposit(int amount) {

        balance += amount;
        return balance;

    }

    // Method for withdrawel, the withdraw method can't put balance below 0.

    public int withdraw(int amount) {

        this.balance -= amount;
        if (balance < 1) {
            gb.getPlayer().setBroke(true);
            return balance;

        } else {
            return balance;
        }
    }

    // standard method for returning balance.
    public int getBalance() { return this.balance; }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
