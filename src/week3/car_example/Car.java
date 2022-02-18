package week3.car_example;

public class Car extends Vehicle{

    protected int numSeats;

    public Car(String regNo, String colour, int numSeats){
        super(regNo, colour);
        this.numSeats = numSeats;
    }

    @Override
    public int getParkingCost(){
        return 600;
    }

}
