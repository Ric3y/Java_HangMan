import java.io.*;
import java.util.*;

public class hangMan {
    private static int guessLeft = 7;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        char[] randomWord = randomWordGenerator(readFile("wordList.txt"));
        char guess;
        boolean guessedTheWord = false;
    
        //Start of game
        System.out.println("WELCOME TO HANGMAN"); 
        System.out.println("You will have " + guessLeft + " attempts to guess a random word");
        System.out.println("Random word is: " + randomWord.toString()); //remove later 

        while (guessLeft > 0) {
            System.out.println("You have " + guessLeft + " left");
            System.out.println("Enter your guess with a character");
            guess = scanner.next().charAt(0);
            System.out.println("You guessed " + guess);
            checkGuess(guess, randomWord);  
        }

        if (guessLeft == 0 && guessedTheWord) {
            System.out.println("Congrats you win :D");
        }
        else if (guessLeft == 0 && !guessedTheWord) {
            System.out.println("You have ran out of attempts but have not guess the word");
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
    public static char[] randomWordGenerator(ArrayList<String> wordsArray) {
        Random random = new Random();
        int randomIndex = random.nextInt(wordsArray.size());
        String randomWord = wordsArray.get(randomIndex);
        return randomWord.toCharArray();
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
    public static void checkGuess(char guess, char[] randomWord) {
        
        //for (int i = 0; i < )
        guessLeft--;
    }
}
