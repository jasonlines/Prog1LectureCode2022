package week3.game_example;
// this is another base class of Game - similar to XboxGame but with different functionality
// as an exercise I've left this very basic - extend it with what you've learned to add fields
// to store the number of gold, silver and bronze trophies available for each game
// (in case you don't play games, Playstation games don't have achievements - they have a
// number of trophies available to win by meeting certain criteria - with bronze being easiest
// and most common, and gold being the hardest and rarest) (you can also get a platinum
// trophy by getting all gold, silver and bronze trophies for a game but we won't worry about
// it here
public class PlaystationGame extends Game{

    // define a separate field for number of bronze trophies, number of silver trophies,
    // and the number of gold trophies

    // you should edit this constructor to set your new fields with arguments that you pass
    // in
    public PlaystationGame(String gameName, String devName, int numPlayers, String ageRating){
        super(gameName, devName, numPlayers, ageRating);
    }

    // as before, a specific implementation of the abstract method in the base class
    public String getInfoString(){
        return "This is a Playstation game called " + this.getGameName();
    }

    // overriding the Game toString
    public String toString(){
        return "This is a Playstation  game and its details are: " + super.toString();
    }

    // very basic test harness to create and print out the toString of a Playstation object
    public static void main(String[] args) {
        Game game = new PlaystationGame("Minecraft", "Mojang", 1, "Everyone");
        System.out.println(game);
    }

}