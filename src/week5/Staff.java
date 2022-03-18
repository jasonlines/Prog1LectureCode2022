package week5;

public class Staff extends Person{

    private int staffNumber;

    public Staff(int staffId, Person.Title title, String firstName, String lastName){
        super(title, firstName, lastName);
        this.staffNumber = staffId;
    }
}
