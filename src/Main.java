import Controllers.GameBoard;

public class Main {

    /**
     * Nothing much to be said.
     * - comment by Gustav
     * @param args
     */
   //public Main() { new GUI()}

    public static void main(String[] args) {

        GameBoard game = GameBoard.getInstance();
        game.startGame();


        // Creates the variables needed for the game to run. The list contains all the player objects that are gonna be created.
        /*List<Object> playerlist = new ArrayList<>();
        Random random = new Random();
        Dice die1 = new Dice();
<<<<<<< HEAD:src/Main.java
=======
        die1.setValue(3);
        ChanceCardDeck deck = new ChanceCardDeck();
        GUI gui = new GUI();
>>>>>>> pushfra02:Matador_GUI/src/Modeller/Main.java

        int tempfield_position0 = 0;
        int tempfield_position1 = 0;
        int tempfield_position2 = 0;
        int tempfield_position3 = 0;
        int field_position = 0;
        ChanceCardDeck deck = new ChanceCardDeck();

        int players;


        // Enters number of players (have to be made into a method for later)
        while (true) {
            players = gui.getUserInteger(" How many players? Max 4 players ");
            if (players > 1 && players < 5) {
                break;
            } else {
                gui.showMessage("Not a valid number");
            }
        }

        // then produces the number of players, probably made into the same method as the above.
        for (int i = 0; i < players; i++) {
            String color = gui.getUserString("What color would you like?");
            String name = gui.getUserString("What would you like your name to be?");


            playerlist.add(new GUI_Player(name, 24-2*players));
            String Cartype = gui.getUserString("What car would you like? Pick between \n TRACTOR, UFO, RACECAR, CAR - Type in everything in caps");
            GUI_Car Car = new GUI_Car(Color.BLACK, Color.BLUE, GUI_Car.Type.getTypeFromString(Cartype), GUI_Car.Pattern.DOTTED);


            gui.getFields()[0].setCar((GUI_Player) playerlist.get(i), true);
        }

        // Player object that keeps changing into other objects.

        GUI_Player currentplayer = (GUI_Player) playerlist.get(0);

        //Game loop that currently never ends




        while (true) {

        //Player 1 turn
            if (currentplayer == playerlist.get(0)) {
                currentplayer = (GUI_Player) playerlist.get(1);
                field_position = tempfield_position1;


        // Player 2 turn
            } else if (currentplayer == playerlist.get(1)) {

                if (players == 2) {
                    currentplayer = (GUI_Player) playerlist.get(0);
                    field_position = tempfield_position0;
                } else {
                    currentplayer = (GUI_Player) playerlist.get(2);
                    field_position = tempfield_position2;
                }
            }

        // Player 3 turn
            else if (currentplayer == playerlist.get(2)) {

            if (players == 3) {
                currentplayer = (GUI_Player) playerlist.get(0);
                field_position = tempfield_position0;

            } else {
                currentplayer = (GUI_Player) playerlist.get(3);
                field_position = tempfield_position3; }


            // Player 4 turn
            } else if (currentplayer == playerlist.get(3)) {
                currentplayer = (GUI_Player) playerlist.get(0);
                field_position = tempfield_position0;
            }


            gui.showMessage("Roll the dice " + currentplayer.getName());

            // Variabels for the die's, use dice class instead.
            //die1.roll();
            int b = random.nextInt(6) + 1;

            // Displays the dices on the board.

            //gui.setDice(die1.getValue(), b);
            gui.setDice(3,3);
            System.out.println("Jeg slog 3 og 3");

            gui.showMessage("You rolled " + die1.getValue());


            gui.getFields()[field_position].setCar(currentplayer, false);
            // Removes the car from the current position on the board


            field_position += die1.getValue();
            field_position = field_position % 24;
            // Moves the car to the new position and takes modoulus to make sure the car will always be inside the array.



            gui.getFields()[field_position].setCar(currentplayer, true);
            // Places the car on the new position on the board.
<<<<<<< HEAD:src/Main.java

            if (field_position == 3 || field_position == 9|| field_position == 15|| field_position == 21) {

                gui.displayChanceCard(deck.DrawCard().getDescription());


            }
            // Function to check if the car is currently on any chancecard spot currently fcks up the program even though it does nothing
            // It has a weird effect on the variables, it produces multiple cars even though the method body only consists of continue.



=======
            System.out.println(field_position);
            if (field_position == 3 || field_position == 9|| field_position == 15|| field_position == 22) {
                // Function to check if the car is currently on any chancecard spot currently fcks up the program even though it does nothing
                // It has a weird effect on the variables, it produces multiple cars even though the method body only consists of continue.
                System.out.println("Hej Anders");
                gui.displayChanceCard(deck.DrawCard(currentplayer, gui).getDescription());
            }
>>>>>>> pushfra02:Matador_GUI/src/Modeller/Main.java
            //Saves location of the player till it's their turn agian.

                   if (currentplayer == playerlist.get(0)) {
                        tempfield_position0 = field_position;

            } else if (currentplayer == playerlist.get(1)) {
                        tempfield_position1 = field_position;

            } else if (currentplayer == playerlist.get(2)) {
                        tempfield_position2 = field_position;

            } else if (currentplayer == playerlist.get(3)) {
                        tempfield_position3 = field_position;
            }

        }

    }*/

    }


}