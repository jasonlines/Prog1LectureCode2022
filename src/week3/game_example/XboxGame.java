package week3.game_example;

// remember - inheritance is an IS A relationship - so by saying that XboxGame extends
// Game, an XboxGame object IS A Game object too. We inherit all fields and methods from
// Game, but can add anything extra that we want to specialise the Game class into an
// XboxGame
public class XboxGame extends Game{

    // we are adding another field for the amount of gamerscore points that are
    // available for a game. Note that we don't need to state that an XboxGame
    // has a game name, dev name, etc  - these are inherited from the base class
    private int gamerscoreAvailable;

    public XboxGame(String gameName, String devName, int numPlayers, String ageRating){
        super(gameName, devName, numPlayers, ageRating);
        this.gamerscoreAvailable = 1000;

        // in this method above we call the constructor from the super/base/parent class.
        // This sets the fields, exactly like the constructor does in Game, so we do not
        // need to rewrite the same code here - we reuse that original constructor, and then
        // add any new logic that we need to (such as setting a default value of 100 for our
        // new field)
    }

    public XboxGame(String gameName, String devName, int numPlayers, String ageRating, int gamerscoreAvailable){
        super(gameName, devName, numPlayers, ageRating);
        this.gamerscoreAvailable = gamerscoreAvailable;

        // another example of a constructor, where this time we pass in a 5th argument to
        // explicitly set the gamerscoreAvailable field. Note that we again must call a
        // super class constructor in this constructor - you must always call a super class
        // constructor in the subclass constructor (and it must be the first line). If you
        // don't specify any constructors then the subclass class will call a default
        // constructor from the base class (i.e. one that requires no arguments). If that's
        // not available you will get a compilation error (please see the example from the
        // week 3 live lecture for more information about this)
    }

    // this is a new method that is specific to XboxGame - we've shown how we can
    // specialise our base class to add extra functionality by doing this becuase
    // we have all of the functinoality from our base class (Game) plus anything we
    // add in the subclass (XboxGame). And remember, we did not need to reimplement
    // isMultiplayer or any of the accessor methods as we inherit them from Game
    public int getGamerscoreAvailable(){
        return this.gamerscoreAvailable;
    }

    // not a very interesting method, but an example of how we had to implement the
    // abstract method from our base class. If you delete this method, the code will
    // not compile as long as getInfoString is abstract in the Game class
    public String getInfoString(){
        return "This is an Xbox game called " + this.gameName;
    }

    // an example of overriding the toString that we inherited from Game, which was already
    // overriding the version that we inherited from toString. If we print out an XboxGame
    // then it will use this version
    public String toString(){
        // note the use of super.toString() here - this lets us use the toString method
        // from our super class and we don't need to repeat that code to use it here. This
        // lets us insert the output of Game's toString with extra information that we want
        // to add in XboxGame's toString
        return "This is an Xbox game and its details are: [" + super.toString()+"] and it has " + this.gamerscoreAvailable + " gamerscore points available";
    }

    // a test harness to demonstrate usage of the class and also show and example of
    // dynamic binding
    public static void main(String[] args) {
        // here we are making a Game reference called genericGame. Remember that Game is
        // abstract, so we can never call a Game constructor, but we can store a reference
        // to a Game. This is because any subclass of Game IS A Game, so we can use this
        // reference to store an XboxGame, a PlaystationGame, or any other class that
        // we write to extend Game
        Game genericGame; // the static type of genericGame is Game

        // creating two versions of Minecraft, one for Xbox and another for Playstation
        XboxGame gameX = new XboxGame("Minecraft", "Mojang", 1, "Everyone");
        PlaystationGame gameP = new PlaystationGame("Minecraft", "Mojang", 1, "Everyone");
        // note that the static type of gameX is XboxGame and the static type
        // of gameP is PlaystationGame

        // to demonstrate this further, we have a simple Game[] that can store two games.
        // Below, we add gameX (an XboxGame) and gameP (a Playstation game) to the array
        // because, since the static type of the array is Game[], it can store any object
        // of that type (or its subclasses).
        Game[] myCollectionOfGames = new Game[2];
        myCollectionOfGames[0] = gameX; // adding a XboxGame to a Game[]
        myCollectionOfGames[1] = gameP; // adding a PlaystationGame to a Game[]

        // now, to demonstrate dynamic binding, we can loop through our array and print
        // out the toString of each Game. Remember, the static type of each element is Game,
        // because this is a Game[], but dynamic binding means the right version of the
        // toString method will be called for each game according to its DYNAMIC TYPE (i.e.
        // what it actually is)
        for(int i = 0; i < myCollectionOfGames.length; i++){
            System.out.println(myCollectionOfGames[i]);
        }




    }

}