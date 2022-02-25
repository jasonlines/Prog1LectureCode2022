package week4;

// another simple class from the live lecture (25/02/22) where we can see a try block with multiple catch blocks to
// deal with different types of Exceptions. Note that these expections are all "unchecked" (i.e. extend
// RuntimeException) so do not need to be within a try/catch (but can be!).
// Please see ExceptionsInDifferentPlaces.java for some examples using checked Exceptions (e.g. they extend Exception
// but are not RuntimeException subclasses)

public class ExceptionsExample {


    public static void main(String[] args) {


        try {
            int[] numbers = {22, 0};

            System.out.println(numbers[0]);
            System.out.println(numbers[1]);

            String message = null;
            message.trim();

            System.out.println(numbers[2]);
            int result = numbers[0]/numbers[1];


            // show catching specific exceptoins
        }catch(ArithmeticException e){
            System.out.println("You can't divide by 0");
        }catch(IndexOutOfBoundsException e){
            System.out.println("The index was out of bounds");
        }catch(Exception e){
            System.out.println("There was a different type of Exception.");

            try{
                int[] useless = new int[0];
                System.out.println(useless[0]);
            }catch(Exception e2){
                System.out.println("What a waste of time");
            }
        }

        System.out.println("We got to the end!");
    }

}
