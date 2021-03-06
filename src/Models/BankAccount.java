package Models;

import Controllers.GameBoard;

public class BankAccount {

    private int balance;


    public BankAccount(int balance) {

        this.balance = balance;

    }

    public GameBoard getGb() {
        return GameBoard.getInstance();
    }

    // Method for depositing money
    public int deposit(int amount) {

        balance += amount;
        return balance;

    }

    // Method for withdrawing, the withdraw method can't put balance below 0.

    public int withdraw(int amount) {

        this.balance -= amount;
        if (balance < 1) {
            getGb().getCurrentPlayer().setBroke(true);
            return balance;

        } else {
            return balance;
        }
    }

    // standard method for returning balance.
    public int getBalance() {
        return this.balance;
    }
}

