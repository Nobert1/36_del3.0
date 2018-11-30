/***********************************************************************************************************************
 // Junior Matador v1.0  Date 30/11/2018      Author: Ida Christensen
 //                                                   Gustav Nobert
 //   The classic monopoly game                       Martin Grønlykke
 //   revised in a simple way for                     Anders Eisenhardt
 //          younger kids                             Alexander Abela
 **********************************************************************************************************************/
import Controllers.GameBoard;

public class Main {

    /**
     * Main method which starts the whole game
     */

    public static void main(String[] args) {
        GameBoard game = GameBoard.getInstance();
        game.startGame();
    }
}