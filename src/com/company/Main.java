import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    static ArrayList<Integer>playerPositions = new  ArrayList<Integer>();
    static ArrayList<Integer>playPositions = new  ArrayList<Integer>();
    static ArrayList<Player> players = new ArrayList<Player>();

    // Method that creates a player from player class and add them to the game.
    public static void main(String[] args) {
        Player p1 = new Player("Player 1", 'X');
        players.add(p1);
        Player p2 = new Player("Player 2", 'O');
        players.add(p2);

        Board gameBoard = new Board();  // createing the gameBoard object. Defines from class Board.java.
        Scanner sc = new Scanner(System.in); // Takes input from user.

        boolean playAgain = true;

    /* While loop from method playAgain
    which clear the board and creates a new board and print it out.*/
        while(playAgain) {
            gameBoard.clearBoard();
            gameBoard.printBoard();

            //Waiting for current player to select field
            boolean incorrectInput = true;

            //currentPlayer's index in players Array their turn.
            int cp = 0;

            // boolean sets to false couse their is no winner from beginning. Same with the while loop.
            boolean won = false;
            boolean tie = false;
            boolean isFull = false;
            while(won == false && tie == false) {

                // While-loop checking for players position if it´s possible  to choose a field and if it´s available.
                while(incorrectInput ) {
                    System.out.println(players.get(cp).getName()+", Choose a field (1-9)");
                    int playerPos = sc.nextInt();
                    if (gameBoard.isOccupied(playerPos)) {
                        System.out.println("Position taken!!");
                    } else {
                        gameBoard.placeMarker(playerPos,players.get(cp).getMarker()); // next player waiting for their turn.
                        incorrectInput = false;
                    }
                    gameBoard.printBoard(); // prints the gameBoard with the marker.
                }
                incorrectInput = true;

                // Winner method, check winner and print out "You Won" to the screen.
                won = gameBoard.checkWinner();
                // if there is no winner it´s a tie game.
                isFull =  gameBoard.isBoardFull();

       /* if statment when someone has won, it will print out
        "You won" and if you wanna play again. If not playAgain will be false*/
                if (won == true) {
                    System.out.println("You won");
                    System.out.println("Do you wanna play again?, yes or no"); // Option to choose if you wanna play again or not.
                    Scanner scanner = new Scanner(System.in);
                    if(scanner.nextLine().equals("no")){ // If player choose yes a new gameboard is created and a new game begin.
                        playAgain = false;
                    }
                    break;
                } else if (isFull == true) {
                    System.out.println("TIE"); // The same with if the game get TIE, if the gameBoard is full the player can choose if playAgain or not.
                    System.out.println("Do you wanna play again?, yes or no");
                    Scanner scanner = new Scanner(System.in);
                    if(scanner.nextLine().equals("no")){
                        playAgain = false;
                    }
                    break;
                }

                //Change player's index (currentPlayer and player).
                if(cp == 0){
                    cp = 1;
                } else {
                    cp = 0;
                }

            } //while(won && tie)
        } // while(playagain)
    } //main()
}