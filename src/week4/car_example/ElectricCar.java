// TO-DO - this needs to be fixed to work properly with the Exception that we've added to the base class' constructor
// (i.e. you need to make the ElecticCar constructor declare that it can throw an IncorrectColourException)

//package week4.car_example;
//
//public class ElectricCar extends Car{
//
//    private double batteryCapacity;
//
//    public ElectricCar(String regNo, String colour, int numSeats, double batteryCapacity){
//        super(regNo, colour, numSeats);
//        this.batteryCapacity = batteryCapacity;
//    }
//
//    public int getParkingCost(){
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        Vehicle[] carPark = new Vehicle[3];
//
//        Car jasonsCar = new Car("EK02DEU", "Red", 5);
//        ElectricCar aaronsCar = new ElectricCar("BOSTROM01", "Green", 4, 2000);
//        Car gavinsCar = new Car("GAVVERS99", "Yellow", 2);
//
//        carPark[0] = jasonsCar;
//        carPark[1] = aaronsCar;
//        carPark[2] = gavinsCar;
//
//        System.out.println(carPark[0].getColour());
//        System.out.println(carPark[1].getColour());
//        System.out.println(carPark[2].getColour());
//
//        System.out.println();
//
//        System.out.println(carPark[0].getParkingCost());
//        System.out.println(carPark[1].getParkingCost());
//        System.out.println(carPark[2].getParkingCost());
//
//    }
//
//}
