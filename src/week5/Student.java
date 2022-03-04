package week5;

public class Student extends Person {

    private int studentNumber;

    public Student(int studentNumber, Title title, String firstName, String lastName){
        super(title, firstName, lastName);
        this.studentNumber = studentNumber;
    }

    public String toString(){
        return "(" + this.studentNumber + ") " + super.toString();
    }

    public static void main(String[] args) {
        Student undergradMe = new Student(3676111, Title.MR, "Jason", "Lines");
        System.out.println(undergradMe);
    }

}
