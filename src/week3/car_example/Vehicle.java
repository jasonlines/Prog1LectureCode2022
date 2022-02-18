package week3.car_example;

public abstract class Vehicle {

    protected String regNo;
    protected String colour;

    public Vehicle(String regNo, String colour){
        this.regNo = regNo;
        this.colour = colour;
    }

    public String getColour(){
        return this.colour;
    }

    public abstract int getParkingCost();

}
