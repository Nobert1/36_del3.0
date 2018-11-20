package Controllers;

import Models.Dice;
import Models.Fields;
import Models.Player;
import Out.gui_out;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;

public class GameBoard{

    private GUI gui;
    private Fields[] fields;
    private Dice die;
    private int players;
    private GUI_Player[] playerArray;

    public GameBoard(){
        this.gui = new GUI();
        this.fields = new Fields[24];
        this.die = new Dice();
        this.players = setPlayers();
        this.playerArray = new GUI_Player[players];


    }

    public void startGame(){
        setPlayerNames();

    }

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

    public void setPlayerNames(){
        for (int i = 0; i < players; i++) {
            String name = gui.getUserString("What would you like your name to be?");
            String Cartype = gui.getUserString("What car would you like? Pick between \n TRACTOR, UFO, RACECAR, CAR");
            Cartype.toUpperCase();
            Cartype.toUpperCase();
            String color = gui.getUserString("What color would you like?");
            GUI_Car Car = new GUI_Car(Color.getColor(color), Color.getColor(color), GUI_Car.Type.getTypeFromString(Cartype), GUI_Car.Pattern.DOTTED);

            GUI_Player spiller = new GUI_Player(name, 24-2*players, Car);
            playerArray[i] = spiller;

            gui.getFields()[0].setCar((GUI_Player) playerArray[i], true);
        }

    }



}