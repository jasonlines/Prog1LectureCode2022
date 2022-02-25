package week4.exception_examples;

// this class was a simple demo to show that you can catch Exceptions in different places. Try experimenting with it
// and refer to the live lecture (25/02/22) to see this code in action

public class ExceptionsInDifferentPlaces {

    // the objective of this class is to show that we can catch Exceptions in different places

    public static void methodC() throws Exception{
        throw new Exception("This is an exception");
    }

    public static void methodB() throws Exception{
       methodC();
    }

    public static void methodA() throws Exception{
        methodB();
    }

    public static void main(String[] args) throws Exception{
        try{
            methodA();
        }catch(Exception e){
            System.out.println("I did handle it");
            e.printStackTrace();
        }
    }

}
