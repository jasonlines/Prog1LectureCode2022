package week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DataStructuresExamples {

    public static void main(String[] args){

        // a simple main method to show the use of some different data structures in Java
        // Two that you should be familiar with:
        // - array
        // - ArrayList
        //
        // Two that may be new to you:
        // - LinkedList (still a list, like ArrayList, with the same operations but a completely different underlying
        //   implementation)
        // - HashMap (and HashSet) - a non-linear data structure that is particularly useful when you need to look
        //   things up (example below is with ISBM numbers and books, but you could also think of scanning products at
        //   a supermarket checkout or similar.


        // example of a list using a simple array
        int[] listOfNumbers = new int[5]; // we have to initialise with the size

        // storing a list of numbers: 3,12,5,7,11

        listOfNumbers[0] = 3;
        listOfNumbers[1] = 12;
        listOfNumbers[2] = 5;
        listOfNumbers[3] = 7;
        listOfNumbers[4] = 11;

        System.out.println("Printing out our array:");
        // print out my list
        for(int i = 0; i < listOfNumbers.length; i++){
            System.out.println(listOfNumbers[i]);
        }
        System.out.println();

        ArrayList<Integer> arrayListOfNumbers = new ArrayList<>();
        arrayListOfNumbers.add(3);
        arrayListOfNumbers.add(12);
        arrayListOfNumbers.add(5);
        arrayListOfNumbers.add(7);
        arrayListOfNumbers.add(11);

        System.out.println("Printing out our ArrayList:");
        for(int i = 0; i < arrayListOfNumbers.size(); i++){
            System.out.println(arrayListOfNumbers.get(i));
        }
        System.out.println();


        LinkedList<Integer> linkedListOfNumbers = new LinkedList<>();
        linkedListOfNumbers.add(3);
        linkedListOfNumbers.add(12);
        linkedListOfNumbers.add(5);
        linkedListOfNumbers.add(7);
        linkedListOfNumbers.add(11);

        System.out.println("Printing out our LinkedList:");
        for(int i = 0; i < linkedListOfNumbers.size(); i++){
            System.out.println(linkedListOfNumbers.get(i));
        }
        System.out.println();


        // 4. hashmap for storing ISBN/Book Titles
        HashMap<String, String> books = new HashMap<>();
        books.put("ABC123", "The Hobbit");
        books.put("DEF456", "Oxford English Dictionary");
        books.put("BME654", "The Hitchhiker's Guide to the Galaxy");
        books.put("HGE872", "The Undead");
        books.put("REW872", "The Lion, the Witch and the Wardrobe");
        books.put("BJB007", "Casino Royale");

        System.out.println("Example of retrieving from a HashMap when the key is present:");
        // retrieve something from my map according to the key
        System.out.println(books.get("BJB007"));

        System.out.println("Example of retrieving from a HashMap when the key is NOT present:");
        // retrieve something from my map according to the key
        System.out.println(books.get("BJB006"));
        System.out.println();

        // Finally a small example of using a HashSet rather than a HashMap (not usually as useful as a HashMap but can
        // be handy when a key/value distinction cannot be made
        HashSet<String> booksOnly = new HashSet<>();
        booksOnly.add("The Hobbit");
        booksOnly.add("Oxford English Dictionary");
        booksOnly.add("The Hitchhiker's Guide to the Galaxy");

        System.out.println("Does the HashSet contain a sequel to the Hobbit?");
        System.out.println(booksOnly.contains("The Hobbit 2: some sequel"));

    }

}
