import java.io.*;
import java.util.*;

public class hangMan {
    private static int guessLeft = 7;
    public static void main(String[] args) throws FileNotFoundException {
        //Variable initialization
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordsArray = new ArrayList<>();
        String randomWord;
        char guess;

        //Call function to get read in file and get random word 
        wordsArray = readFile("wordList.txt");
        randomWord = randomWordGenerator(wordsArray);
        
        //censor random word with underscores 
        //censorWord = "_____"
        char[] censorWord = randomWord.toCharArray();
        for(int i = 0; i < censorWord.length; i++) {
            censorWord[i] = '_';
        }

        //Start of game
        System.out.println("Welcome to Hang Man"); 
        System.out.println("You will have 7 attemps to guess a random 5 letters word");
        System.out.print("Random word is: " + randomWord); //remove later 

        while (guessLeft > 0) {
            System.out.print("Enter your guess with a character");
            guess = scanner.next().charAt(1);
            checkGuess(guess);
            System.out.println(guessLeft);
            System.out.println(guess);  
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
            // Read the text file line by line.
            while ((line = reader.readLine()) != null) {
                // Split each line into words using the newline character as a delimiter.
                String[] lineWords = line.split("\n");

                // Add each word to the ArrayList.
                for (String word : lineWords) {
                    wordsArray.add(word);
                }
            }
            reader.close();
        } catch (Exception e) {
            // Handle any exceptions when file does not exist.
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return wordsArray;
    }

    /**
    * Generates a random word from a given ArrayList of words.
    */
    public static String randomWordGenerator(ArrayList<String> wordsArray) {
        Random random = new Random();
        // Generate a random index within the range of the ArrayList size.
        int randomIndex = random.nextInt(wordsArray.size());
        String randomWord = wordsArray.get(randomIndex);
        return randomWord;
    }

    /**
    * Check user input to word, main game logic here 
    */
    public static void checkGuess(char guess) {
        guessLeft--;
    }
}
