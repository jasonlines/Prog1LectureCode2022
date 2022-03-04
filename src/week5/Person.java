package week5;

// this code is from the week 5 live lecture and is a good starting point for you to have a play with. We've created
// an abstract base class to represent a Person - we don't want to be able to create an object of type Person in this
// program (hence making it abstract) but we DO want to share the implementation with two specialisations of Person -
// these are Student and Staff. We've started the implementation below with an enum for Title, and we've so far added
// a student number to the Student class. Try now creating the Staff class (with an extra field for staffID) to see
// we can further specialise Person into something different to Student (even though Staff and Student both share some
// important fields like title and names.

public abstract class Person {

    public enum Title {MR, MS, MISS, MRS, DR, PROF, PREFER_NOT_TO_SAY}

    private Title title;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){
        this.title = Title.PREFER_NOT_TO_SAY;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Title title, String firstName, String lastName){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String newName){
        this.firstName = newName;
    }

    public String toString(){
        return this.title + " " + this.firstName + " " + this.lastName;
    }

}
