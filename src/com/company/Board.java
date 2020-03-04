import java.util.*;


public class Board {
    private char [] gameBoard = new char [9];
    private int counter = 0;

    // Create the table
    public Board() {
        gameBoard[0] = ' ';
        gameBoard[1] = ' ';
        gameBoard[2] = ' ';
        gameBoard[3] = ' ';
        gameBoard[4] = ' ';
        gameBoard[5] = ' ';
        gameBoard[6] = ' ';
        gameBoard[7] = ' ';
        gameBoard[8] = ' ';
    }

    public void printBoard() {
        System.out.println("--------------");
        System.out.println("| " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
        System.out.println("--------------");
        System.out.println("| " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
        System.out.println("--------------");
        System.out.println("| " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
        System.out.println("--------------");
    }
////

    // checks if placeany position is occupied otherwise it will print marker.
    public void placeMarker(int position, char marker) {
        if (isOccupied(position)) {
            System.out.println("You can´t put in here!!");
        }
        else {
            gameBoard[position-1] = marker;
        }


    }
    // All winning options, return true if player gets three in a row X or O.
    public boolean checkWinner(){
//Row control
        if (check(gameBoard[0],gameBoard[1],gameBoard[2]) )
            return true;
        if (check(gameBoard[3],gameBoard[4],gameBoard[5]) )
            return true;
        if (check(gameBoard[6],gameBoard[7],gameBoard[8]) )
            return true;
        //Column control
        if (check(gameBoard[0],gameBoard[3],gameBoard[6]) )
            return true;
        if (check(gameBoard[1],gameBoard[4],gameBoard[7]) )
            return true;
        if (check(gameBoard[2],gameBoard[5],gameBoard[8]) )
            return true;
        //Diagonal control
        if (check(gameBoard[6],gameBoard[4],gameBoard[2]) )
            return true;
        if (check(gameBoard[0],gameBoard[4],gameBoard[8]) )
            return true;

        return false;

    }
    // Check if there is three in a row with three of a kind.
    public boolean check(char a, char b, char c){
        if(a == b && b == c && c != ' '){
            return true;
        }
        return false;
    }
    // Check if the position is occupied or not.
    public boolean isOccupied(int position) {
        if( gameBoard[position -1] ==  ' ' ){
            return false;
        } else {
            return true;
        }
    }

    // Method look for if there is any place left to place one the gameBaord.
    public boolean isBoardFull() {
        for ( int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i] == ' ' ) {
                return false;
            }
        }
        return true;
    }
    // Create a new empty gameBoard.
    public void clearBoard() {

        for(int i=0;i<9;i++ ){
            gameBoard[i]=' ';
        }

    }

}




