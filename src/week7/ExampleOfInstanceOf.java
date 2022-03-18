package week7;

import week5.Person;
import week5.Staff;
import week5.Student;

public class ExampleOfInstanceOf {

    // the operation that we will be focusing on is instanceof

    public static void main(String[] args) {

        Person bob = new Student(123456, Person.Title.MX, "Bob", "Bobbert");
        Person jason = new Staff(987654321, Person.Title.DR, "Jason", "Lines");

        Person personOfInterest = jason;

        if(personOfInterest instanceof Staff){
            System.out.println("This person is a member of staff");
        }else if(personOfInterest instanceof Student){
            System.out.println("This person is a student");
        }else{
            System.out.println("I don't know what to do with this person");
        }



    }
}
