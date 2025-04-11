import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** MorseCodeConverter provides functionality to convert Morse code to English text.
 * @author Okeoghene Excel Omorobe
 */
public class MorseCodeConverter {

    // Static instance of the MorseCodeTree used for lookups
    private static MorseCodeTree tree = new MorseCodeTree();

    /**
     * Converts a Morse code string to English.
     * Each letter in Morse code is separated by a space,
     * and words are separated by a " / ".
     *
     * @param code Morse code input string
     * @return English translation of the Morse code
     */
    public static String convertToEnglish(String code) {
        StringBuilder english = new StringBuilder();

        // Split input into words using " / " as the delimiter
        String[] words = code.trim().split(" / ");

        // Loop through each word
        for (String word : words) {
            // Split word into individual Morse letters
            String[] letters = word.split(" ");
            for (String letter : letters) {
                english.append(tree.fetch(letter)); // Convert Morse to English letter
            }
            english.append(" "); // Add space between words
        }

        return english.toString().trim(); // Remove trailing space and return
    }

    /**
     * Converts Morse code from a file into English.
     *
     * @param file The file containing Morse code
     * @return English translation of the Morse code in the file
     * @throws FileNotFoundException if the file is not found
     */
    public static String convertToEnglish(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder code = new StringBuilder();

        // Read each line and build a complete Morse code string
        while (scanner.hasNextLine()) {
            code.append(scanner.nextLine()).append(" ");
        }

        scanner.close();

        // Convert the collected Morse code string to English
        return convertToEnglish(code.toString());
    }

    /**
     * Returns a space-separated string of the tree’s contents in LNR (in-order) traversal.
     *
     * @return String representation of all values in the MorseCodeTree in sorted order
     */
    public static String printTree() {
        return String.join(" ", tree.toArrayList());
    }
}
