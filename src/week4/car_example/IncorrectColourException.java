package week4.car_example;

// this is an example of a custom Exception class. Note that it extends Exception so it IS an Exception, plus anything
// we wish to add. In this case, we don't want to add any additional functionality but we've included two constructors.
// Remember - if we don't provide ANY constructors then there will be a default one (that takes no args), but as soon
// as we add out own constructor then that implicit default one disappears. In this case, we wanted a constructor that
// could take a String message (and then that uses the Exception classes constructor that also takes a String) so we've
// specifically added that constructor, plus we also want to recreate the default implicit one so have two sepearate
// constructors in the example below:

public class IncorrectColourException extends Exception{

    public IncorrectColourException(){
        super();
    }

    public IncorrectColourException(String message){
        super(message);
    }

}
