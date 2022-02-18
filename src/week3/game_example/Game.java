package week3.game_example;

// Game is an abstract class that implements the common functionality that we want
// our subclasses to each have. Because it is abstract, it means that it is not
// possible to instantiate a Game object
public abstract class Game {

    // same fields as what we've seen previously. Note that we've made them private
    // so that we can directly access them in our subclasses. Try changing these to
    // private if you want to see how the access modifier changes how you can interact
    // with the fields
    protected String gameName;
    protected String devName;
    protected int numPlayers;
    protected String ageRating;

    // Single constructor to set all fields when making a Game (note: remember this
    // class is abstract so we cannot ACTUALLY create a Game object, but we will use
    // this constructor in our subclasses so we don't have to repeat redundant code
    // in both)
    public Game(String gameName, String devName, int numPlayers, String ageRating){
        this.gameName = gameName;
        this.devName = devName;
        this.numPlayers = numPlayers;
        this.ageRating = ageRating;
    }

    // accessors for each field, but we have devided not to have mutators for any of
    // our fields
    public String getGameName(){
        return this.gameName;
    }

    public String getDevName(){
        return this.devName;
    }

    public int getNumPlayers(){
        return this.numPlayers;
    }

    public String getAgeRating(){
        return this.ageRating;
    }

    // choosing not to have any mutators

    // a class-specific method like we've seen before
    public boolean isMultiplayer(){
        if(this.getNumPlayers() > 1){
            return true;
        }
        return false;

        // note, we saw that we could implement this method in different ways
        // a much shorter approach would be the following (try it for yourself
        // if you would like to check!)
        // return this.getNumPlayers > 1;

    }

    // this is just a silly example of an abstract method - here, we declare the method
    // and say it is abstract. We don't need to implement it here, but it foreces our
    // subclasses to implement their own versions of it (as they can't rely on a base class
    // implementation from here)
    public abstract String getInfoString();

    // an example of method overriding - toString() is inherited from the Object class,
    // as all classes in Java implicitly extend Object - so they will have an implementation
    // of toString that they can use. Here, we redefine what this does for Game objects so
    // that it returns something more sensible
    public String toString(){
        return this.gameName+", "+this.devName+", "+this.numPlayers+", "+this.ageRating;
    }

    // this used to be a test harness for Game, but now that the class is abstract
    // we cannot actually create a Game object to test it! We can still run the
    // local main method here though so I've left it in as an example
    public static void main(String[] args){
        System.out.println("I will still print if you run this main method!");
        // Game game = new Game("Fifa", "EA Sports", 8, "Everyone");
        // even though the above matches our constructor, we cannot use it because
        // Game is an abstract class
    }


}