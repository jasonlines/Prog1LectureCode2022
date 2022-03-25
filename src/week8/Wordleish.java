package week8;

import java.util.Locale;
import java.util.Scanner;



public class Wordleish {

    //fields/attributes
    private String correctWord;
    private int numberOfGuessesRemaining;

    // constructor(s)?
    public Wordleish(String correctWord) throws IncorrectNumberOfCharactersException{
        if(correctWord.length() != 5){
            throw new IncorrectNumberOfCharactersException();
        }
        this.correctWord = correctWord.toUpperCase();
        this.numberOfGuessesRemaining = 6;
    }

    // other operations (e.g. accessor/mutator/class-specific/toString, etc
    public boolean guess(String guessWord) throws IncorrectNumberOfCharactersException, TooManyGuessesException{

        if(numberOfGuessesRemaining <= 0){
            throw new TooManyGuessesException();
        }

        String guessWordToUpperCase = guessWord.toUpperCase();

        if(guessWordToUpperCase.length() != 5){
            throw new IncorrectNumberOfCharactersException(guessWordToUpperCase +" is invalid - it must be 5 characters");
        }

        for(int i = 0; i < guessWordToUpperCase.length(); i++){
            // if character is correct and in the correct locaiton
            if(guessWordToUpperCase.charAt(i) == this.correctWord.charAt(i)){
                System.out.print(ConsoleColours.ANSI_GREEN_BACKGROUND + guessWordToUpperCase.charAt(i) + ConsoleColours.ANSI_RESET + " ");
            }else if(correctWord.contains(guessWordToUpperCase.charAt(i)+"")){ // else if the character is in the word but elsewhere
                System.out.print(ConsoleColours.ANSI_YELLOW_BACKGROUND + guessWordToUpperCase.charAt(i) + ConsoleColours.ANSI_RESET + " ");
            }else{
                System.out.print(ConsoleColours.ANSI_WHITE_BACKGROUND + ConsoleColours.ANSI_BLACK + guessWordToUpperCase.charAt(i) + ConsoleColours.ANSI_RESET + " ");
            }
        }
        System.out.println();

        this.numberOfGuessesRemaining--;

        if(this.numberOfGuessesRemaining==0){
            throw new TooManyGuessesException();
        }

        return this.correctWord.equalsIgnoreCase(guessWord);
    }



}
