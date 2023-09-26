import java.io.*;
import java.util.*;

public class hangMan {
    public static void main(String[] args) throws FileNotFoundException {
        //test stuff
        ArrayList<String> wordsArray = new ArrayList<>();
        String randomWord;

        wordsArray = readFile("wordList.txt");
        randomWord = randomWordGenerator(wordsArray);
        System.out.println(randomWord);
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
            // Handle any exceptions when file does not exist
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

}
