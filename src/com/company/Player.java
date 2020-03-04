/* Player input, it takes a player and a marker to play the game.
 Then we create a getMarker() method which take marker input to gameBoard and a getName() method which take player input. */

public class Player {

    private String name;
    private char marker;

    public Player (String name, char marker){
        this.name = name;
        this.marker = marker;
    }
    public String getName() {
        return this.name;
    }

    public char getMarker() {
        return this.marker;
    }






}
