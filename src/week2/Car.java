package week2;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Car {

    // fields
    private String make;
    private String model;
    private String reg;
    private String owner;

    // constructor(s)
    public Car(String make, String model, String registration, String owner){
        this.make = make;
        this.model = model;
        this.reg = registration;
        this.owner = owner;
    }

//    //Example not using the this. operator (but works the same as the constructor above)
//    public Car(String makeOfCar, String theModel, String regNo, String theOwner){
//        make = makeOfCar;
//        model = theModel;
//        registration = regNo;
//        owner = theOwner;
//    }

    // accessors/mutators
    // remember - our class has fields for make, model, reg and owner
    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public String getReg(){
        return this.reg;
    }

    public String getOwner(){
        return this.owner;
    }

    // mutators - note that we don't want changes to be allowed for make and model, just reg and owner
    public void setReg(String reg){
        this.reg = reg;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    // class-specific methods
    public String toString(){
        return "This car is a " + this.make +" " + this.model + ". Its registration is " + this.reg +
                " and it is owned by " + this.owner;
    }

    // test harness
    public static void main(String[] args) throws IOException{

        // quick example of reading from file to populate three Car objects

        // First, we start with an input file that I've saved in the root directory of this project (carInput.txt).
        // I will create a File object within Java by passing the filename in as an argument, and then create a
        // Scanner to go through each line of the file (using the "\n" delimiter). Then, on each line, I can eithe use
        // a second Scanner to separate parts out of each line, or I can use the String method .split(",") where "," is
        // the delimiter that I want to use. If I use .split, it will return an array with everything up to the first ,
        // in position [0], everything up to the next , in position [1], and so on until we run out of data to split
        // 1. create a file object
        // 2. create a scanner object
        // 3. tell the scanner how to split input up
        // 4. proceed through the input line by linke
        // 5. for each line, use another Scanner to split up the individual line into parts or use .split
        // 6. Create a Car object from these parts and then print its toString

        // 1. Creating the file
        File inputFile = new File("carInput.txt");

        // 2. Creating the scanner (and setting my file from 1 as the input to my Scanner)
        Scanner scan = new Scanner(inputFile);

        // 3. Tell our Scanner (called scan) what delimiter to use. Our file has records for a different car on each
        // line so we will use the newline character "\n"
        scan.useDelimiter("\n");

        // 4. Now we wish to loop through each line of the file until we run out of them. We may not know how many lines
        // there are in advance so we can use a while loop - Scanner has a couple of useful methods here:
        //  - next()    // This returns everything in the input up to the next occurance of the delimiter
        //  - hasNext() // Returns true if there's anything left to scan, false if we're at the end of the file/inpu

        // becuase of the hasNext metohd, we can how have a while(scan.hasNext()) that will visit each line of our input
        // until we run out of data in our file (and then that will stop)

        // Let's also declare some variables that we'll reuse in the loop - not setting any values yet, just declaring
        // them for later use
        String line;
        Car car;

        // We will also declare both of these for later - don't worry about them until we're inside the while loop
        Scanner lineScanner;
        String[] lineParts;

        while(scan.hasNext()){ // e.g. while there is more data after the most recent \n (or if it's the first call)
            System.out.println("Starting an iteration of my while loop (e.g. new line of data is being used)");
            line = scan.next(); // on the first loop, line will be the first line of the file
            System.out.println("line: " + line); // uncomment this print statement if you want to check

            // now we want to split line up into the bits we need to Construct a Car
            // We know that the first line of our input is:
            //      Ford,Fiesta,EK02DEU,Scrapheap
            // Therefore we want to pass the first thing up to , as the make of a new car, the second bit as the model,
            // and then the same for reg and owner

            // There are two (equally valid ways to do this)
            // 1. we could have a new Scanner that just works on line and uses a delimiter of "," instead of "\n"
            // 2. we can use the .split(",") method of the String class on line to rerun an array broken up by
            // occurances of "," - more info on split can be found in the Java API if you're interested
            // (https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split(java.lang.String))

            // Option 1 - create using a second Scanner

            lineScanner = new Scanner(line); // making a separate scanner that will use the current line as input
            lineScanner.useDelimiter(",");   // the data on a line is comma separated, so use "," instead of new line

            // we can then use our lineScanner to get each bit from the start of the line to the first , as make, then
            // call .next to get the model afterwards, then reg, then owner
            String make = lineScanner.next().trim();
            String model = lineScanner.next().trim();
            String reg = lineScanner.next().trim();
            String owner = lineScanner.next().trim();
            // note, I've also called .trim() on each input as this removes any additional leading/trailing white space
            // that might be in the file. Not always necessary but it's a good idea to always do this as it's good
            // practice (unless you do want your String values to include whitespace at the start/end!)

            // note: if you want to debug here, either print out make, model, etc. to verify what's happening, or use
            // a breakpoint with the debugger (like I showed in the first live lecture) to inspect how the values change
            // e.g.
            System.out.println("make: " + make);
            System.out.println("model: " + model);
            System.out.println("reg: " + reg);
            System.out.println("owner: " + owner);

            // we now have the four parts of our line extracted so we can construct a Car object using the constructor
            // on line 15
            car = new Car(make, model, reg, owner);
            // to verify that it's correct, let's print its toString method:
            System.out.println("New car created! : " + car);
            System.out.println(); // adding a blank line to the output to make it easier to read

            lineScanner.close(); // it's good practice to call .close on a Scanner when you're done with it to free up
                                 // memory (not usually a problem unless your input data is very large though!)
            // next time this loop iterates it will move onto the next line of the input, initialise line to some new
            // data, create lineScan on that new line, and then create a new car. Note that at the moment each new car
            // will just overwrite the old one in the car variable - it would be better to add each new Car to an array
            // or some other structure so we can use them later (much like you did in CW1 when making Track and Album
            // objects. I'll leave this as an exercise however as here we're showing how to make them and then print


            // FINAL NOTE: option 2 - using .split instead of a second scanner
            // instead of using lineScanner, I could also have used:

            // lineParts = line.split(",");
            // System.out.println("Creating a new car:");
            // car = new Car(lineParts[0].trim(), lineParts[1].trim(), lineParts[2].trim(), lineParts[2].trim());
            // System.out.println(car);

            // this would have done the same thing! It works by splitting the String that .trim() is called on (in this
            // case it was what we called line) and creates a String[] that splits the input by whatever arg is passed
            // into the split method (in this case, on 169, I used ","). The size of output array depends on how many
            // delimiters are in the input (I know it should output 4 in this case but you can check the size of an
            // array programmatically).
            //
            // Don't worry if the split() method is a bit confusing - I'll demo it in a live lecture. If you'd like
            // to try it though, comment out lines 129-157 (where we used lineScan) and uncomment lines 169-172. You
            // should see that the Car objects are constructed and printed just fine
        }
        scan.close(); // as with the lineScanner, make sure to .close() the original Scanner when you're finished with
                      // it too to avoid running out of memory (this happens if you load a large input into a Scanner as
                      // it stays in memory until the end of the program, and may cause issues if it's very large! This
                      // This is also why Gavin teaches you to use buffered readers - but generally I don't worry about
                      // those unless the input is very large (e.g. several Gb!)


        //  I've also left in the original test harness code that we wrote during the lecture - leaving it here for
        //  reference and I recommend you always start with hardcoded values to verify things are working before
        //  worrying about reading in a file
        //
        // Car jasonsOldCar = new Car("Ford", "Fiesta", "EK02DEU", "Mr Jason Lines");
        // Car jasonsNewCar = new Car("Citroen", "DS3", "AB22JAY", "Dr Jason Lines");
        // System.out.println("My old car:");
        // System.out.println(jasonsOldCar);
        // System.out.println("Changing the owner:");
        // jasonsOldCar.setOwner("the scrapheap");
        // System.out.println(jasonsOldCar);


    }

}
