package week8;

import java.util.Scanner;

public class WordleishSimulator {

    public static void main(String[] args) {

        Wordleish myGame = null;

        try {
            myGame = new Wordleish("DEPOT");
        }catch(IncorrectNumberOfCharactersException e){
            System.out.println("The initial word was invalid due to the number of characters (must be 5). Initialising with a default word of \"HELLO\"");
            try{
                myGame = new Wordleish("HELLO");
            }catch (IncorrectNumberOfCharactersException e2){
                e2.printStackTrace();
            }
        }

        Scanner inputScanner = new Scanner(System.in);

        boolean keepPlaying = true;
        String userGuess;

        while (keepPlaying) {
            System.out.println("Please enter a guess:");
            userGuess = inputScanner.next();

            try {
                if (myGame.guess(userGuess)) {
                    keepPlaying = false;
                    System.out.println("Congratulations! You've beaten me");
                } else {
                    System.out.println("Incorrect guess");
                }
            }catch(IncorrectNumberOfCharactersException e){
                System.out.println("Invalid guess - please use 5 character words only");
            }catch(TooManyGuessesException e){
                System.out.println("GAME OVER - you are out of guesses");
                keepPlaying = false;
            }
            System.out.println();
        }

    }

}
