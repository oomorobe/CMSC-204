import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Implements the CourseDBStructureInterface.
 * Uses a hash table with chaining (linked lists) to store CourseDBElement objects.
 * 
 * @author Okeoghene Excel Omorobe
 */
public class CourseDBStructure implements CourseDBStructureInterface {

    // The hash table is an array of linked lists of CourseDBElements
    private LinkedList<CourseDBElement>[] hashTable;

    // The size of the hash table
    private int tableSize;

    /**
     * Constructor used for testing purposes.
     * Sets the table size directly.
     *
     * @param testing A dummy parameter to differentiate the constructor
     * @param size    Size of the hash table
     */
    public CourseDBStructure(String testing, int size) {
        tableSize = size;
        hashTable = new LinkedList[tableSize]; // Initialize the hash table
    }

    /**
     * Main constructor that calculates table size based on desired load factor (1.5).
     * Uses a prime number in the form of 4k + 3 for better hash distribution.
     *
     * @param n Number of elements expected to store
     */
    public CourseDBStructure(int n) {
        tableSize = getNext4kPlus3Prime((int) (n / 1.5)); // Calculate a prime table size
        hashTable = new LinkedList[tableSize]; // Initialize the hash table
    }

    /**
     * Adds a CourseDBElement to the hash table.
     * If an element with the same CRN already exists, it updates it.
     *
     * @param element The CourseDBElement to add
     */
    @Override
    public void add(CourseDBElement element) {
        int index = Math.abs(element.hashCode()) % tableSize; // Hash to get index
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>(); // Create a new list if needed
        }

        // If the CRN already exists, remove the old entry
        for (CourseDBElement existing : hashTable[index]) {
            if (existing.getCRN() == element.getCRN()) {
                hashTable[index].remove(existing);
                break;
            }
        }

        // Add the new or updated element to the list
        hashTable[index].add(element);
    }

    /**
     * Retrieves a CourseDBElement by its CRN.
     *
     * @param crn The CRN of the course to retrieve
     * @return The matching CourseDBElement
     * @throws IOException If the CRN is not found in the structure
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        int index = Math.abs(Integer.toString(crn).hashCode()) % tableSize;

        // Check the linked list at the index, if it exists
        if (hashTable[index] != null) {
            for (CourseDBElement element : hashTable[index]) {
                if (element.getCRN() == crn) {
                    return element; // Return if found
                }
            }
        }

        // Throw exception if CRN is not found
        throw new IOException("CRN not found: " + crn);
    }

    /**
     * Returns a list of string representations of all stored CourseDBElements.
     *
     * @return ArrayList of course information strings
     */
    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> output = new ArrayList<>();

        // Loop through each bucket in the hash table
        for (LinkedList<CourseDBElement> bucket : hashTable) {
            if (bucket != null) {
                for (CourseDBElement element : bucket) {
                    output.add("\n" + element.toString()); // Add formatted string
                }
            }
        }

        return output;
    }

    /**
     * Returns the size of the hash table (number of buckets).
     *
     * @return The table size
     */
    @Override
    public int getTableSize() {
        return tableSize;
    }

    /**
     * Helper method to find the next prime number of the form 4k + 3
     * that is greater than or equal to the specified minimum.
     *
     * @param min The minimum number to start checking from
     * @return A prime number in the form 4k + 3
     */
    private int getNext4kPlus3Prime(int min) {
        int k = (min + 1) / 4;
        int candidate = 4 * k + 3;

        // Keep checking next numbers until a prime is found
        while (!isPrime(candidate)) {
            k++;
            candidate = 4 * k + 3;
        }

        return candidate;
    }

    /**
     * Helper method to determine if a number is prime.
     *
     * @param num The number to check
     * @return true if prime, false otherwise
     */
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        // Only check up to the square root of num
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }

        return true;
    }
}
