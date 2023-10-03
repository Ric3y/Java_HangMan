import java.io.*;
import java.util.*;

public class hangMan {
    private static int guessLeft = 7;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String randomWord = randomWordGenerator(readFile("wordList.txt"));
        char guess;
    
        //Start of game
        System.out.println("WELCOME TO HANGMAN"); 
        System.out.println("You will have " + guessLeft + " attemps to guess a random word");
        System.out.println("Random word is: " + randomWord); //remove later 

        while (guessLeft > 0) {
            System.out.println("You have " + guessLeft + " left");
            System.out.println("Enter your guess with a character");
            guess = scanner.next().charAt(0);
            System.out.println("You guessed " + guess);
            checkGuess(guess);  
        }


        scanner.close();
    }

    /** 
     * Takes in a text file to read and stores its contents as a list of words in an ArrayList.
     */
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> wordsArray = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\n");

                for (String word : lineWords) {
                    wordsArray.add(word.toLowerCase());
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return wordsArray;
    }

    /**
    * Generates a random word from a given ArrayList of words.
    */
    public static String randomWordGenerator(ArrayList<String> wordsArray) {
        Random random = new Random();
        int randomIndex = random.nextInt(wordsArray.size());
        String randomWord = wordsArray.get(randomIndex);
        return randomWord;
    }

    /**
    * Generates an array of underscores(_) given a word
    */
    public static char[] censorWord(String word) {
        char[] censorWord = word.toCharArray();
        for(int i = 0; i < censorWord.length; i++) {
            censorWord[i] = '_';
        }
        return censorWord;
    }

    /**
    * Check user input to word, main game logic here 
    */
    public static void checkGuess(char guess) {
        guessLeft--;
    }
}
