package week7;

public class RecursionExamples {

    public static void infiniteIteration(String message){
        while(true){
            System.out.println(message);
        }
    }

    public static void infiniteRecursion(String message){
        System.out.println(message);
        infiniteRecursion(message);
    }

    public static void finiteIteration(String message, int numIterations){
        for(int iteration = 0; iteration < numIterations; iteration++){
            System.out.println(message);
        }
    }

    public static void finiteRecursion(String message, int numRecursions){
        System.out.println("numRecursion: "+numRecursions);
        if(numRecursions < 1){ // base case
            return;
        }
        System.out.println(message);
        finiteRecursion(message, numRecursions-1);
    }

    public static void main(String[] args){
//        infiniteIteration("Hello this is a message");
//        infiniteRecursion("Hello this is a recursive method");
//        finiteIteration("This is a finite iterative message", 5);
        finiteRecursion("This is a finite recursive message", 5);
    }
}
