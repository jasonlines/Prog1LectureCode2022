package week8;

public class IncorrectNumberOfCharactersException extends Exception {

    public IncorrectNumberOfCharactersException(){
        super();
    }

    public IncorrectNumberOfCharactersException(String message){
        super(message);
    }
}
