package week4.car_example;

public class Car extends Vehicle{

    protected int numSeats;

    public Car(String regNo, String colour, int numSeats) throws IncorrectColourException{
        super(regNo, colour);
        this.numSeats = numSeats;
    }

    @Override
    public int getParkingCost(){
        return 600;
    }

    public String toString(){
        return super.toString() + ", Num. Seats: " + this.numSeats;
    }

    // main method/test harness to demonstrate that we now need to try/catch when creating Car objects as the
    // constructor may throw an Exception (specifically, and IncorrecctColourException). The example below will compile,
    // as both RED and YELLOW are valid colours, but try changing either and you'll see that an Exception is now
    // thrown in the Car constructor
    public static void main(String[] args) {

        try {
            Car firstCar = new Car("EK02DEU", "RED", 5);
            System.out.println(firstCar);

            System.out.println();

            Car gavinsOldCar = new Car("GAVVERS01", "YELLOW", 2);       // "YELLOW" is a valid choice for our enum
//            Car gavinsOldCar = new Car("GAVVERS01", "Orange", 2);     // "Orange" is not, so this would throw an
                                                                        // Exception
            System.out.println(gavinsOldCar);

        }catch (IncorrectColourException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
