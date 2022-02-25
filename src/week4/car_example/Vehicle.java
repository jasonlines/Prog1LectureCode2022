package week4.car_example;

public abstract class Vehicle {

    // enum use here forces colours to be from a discrete set of values (e.g. pink would not be allowed)
    public enum Colour{WHITE, GREY, BLACK, YELLOW, RED}

    protected String regNo;
    protected Colour colour;

    // constructor still takes a String - we can convert it to our enum using the .valueOf method (note that it is
    // case sensitive
    public Vehicle(String regNo, String colour) throws IncorrectColourException{
        this.regNo = regNo;
        try {
            this.colour = Colour.valueOf(colour); // this method will throw an IllegalArgumentException if a value is
                                                  // passed that is not valid for our enum (e.g. "Red" as it's case
                                                  // sensitive, or something else such as "PURPLE")

        // instead of just declaring that this constructor throws IllegalArgumentException we can instead catch that
        // Exception and do anything we like - in this case, we will throw an instance of our own Exception class that
        // we've called IncorrectColourException, and then we can catch that specificaly elsewhere
        }catch(IllegalArgumentException e){
            throw new IncorrectColourException(colour + " is not a valid choice for colour");
        }
    }

    public String getColour(){
        return this.colour.toString().toLowerCase();
    }

    public abstract int getParkingCost();

    public String toString(){
        return "Reg: "+ this.regNo + ", Colour: " + this.colour.toString().toLowerCase();
    }

}
