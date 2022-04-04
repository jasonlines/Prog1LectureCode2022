package discussion_board_examples;

public class Staff extends Person{

    private String userName;

    public Staff(String name, String userName){
        super(name);
        this.userName = userName;
    }

    public String getUsername(){
        return this.userName;
    }

    public static void main(String[] args) {
        Person jeremy = new Person("Jeremy Jamm");
        Person ron = new Staff("Ron Swanson", "ron22prk");

        /* compile time error - Jeremy is a Person, not Staff, so does not have a
           userName and there is no getUserName() method in Person
        */
        // System.out.println(jeremy.getUserName());

        /* compile time error - the variable ron is declared as a Person - so even
           though the object that it stores is a Staff object, which has a username
           and the Staff class has a .getUserName() method, it cannot be used as
           the compiler treats ron as its static declared type (Person)
        */
        // ron.getUserName(); // compile time error - the ron variable is

        /* this works though! Even though the variable called ron is declared as a
           Person, we can force the compiler to treat it as a Staff object by casting.
           Casting is effectively overriding the compiler and saying "trust me" - which
           can be useful in cases such as this where we need to case a superclass variable
           into a subclass, but it can result in an Exception if you try to cast an object
           into a completely unrelated type (e.g. casting a String as a Person would not
           make sense). And note that all Staff objects are Person objects, but not all Person
           objects are Staff objects, so casting in the other direction would not make sense
         */
        System.out.println("Casting ron as Staff (should work)");
        System.out.println(((Staff)ron).getUsername());

        // the format for casting is (ClassName)variableName where variableName is your obj
        // and ClassName is the class that you are telling the compiler to assume
        // variableName is e.g. (Staff)ron in this case treats ron as Staff, even though it's
        // declared as Person

        // e.g. you cannot do this:
        System.out.println("\nCasting jeremy as Staff (should NOT work)");
        System.out.println(((Staff)jeremy).getUsername()); // valid at compile time but will throw Exception
    }

}
