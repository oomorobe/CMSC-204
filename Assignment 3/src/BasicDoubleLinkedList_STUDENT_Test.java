import static org.junit.Assert.*; // Importing JUnit assertion methods
import java.util.Comparator; // Importing Comparator for comparing elements during removal
import java.util.ListIterator; // Importing ListIterator to traverse the linked list
import java.util.NoSuchElementException; // Importing exception for iterator errors
import org.junit.Before; // JUnit annotation to execute setup before each test
import org.junit.Test; // JUnit annotation to define test methods

/**
 * JUnit test class for testing the BasicDoubleLinkedList implementation.
 * This class ensures correct functionality of adding elements, removing elements,
 * and iterator behavior in a doubly linked list.
 */
public class BasicDoubleLinkedList_STUDENT_Test {
    private BasicDoubleLinkedList<Integer> list; // Instance of the doubly linked list

    /**
     * This method runs before each test case. It initializes a BasicDoubleLinkedList
     * and populates it with initial values.
     */
    @Before
    public void setUp() {
        list = new BasicDoubleLinkedList<>(); // Initializes an empty doubly linked list
        list.addToEnd(10); // Adds elements to the end of the list
        list.addToEnd(20);
        list.addToEnd(30);
    }

    /**
     * Tests that an element can be added to the front of the list
     * and verifies that it becomes the first element.
     */
    @Test
    public void testAddToFront() {
        list.addToFront(5); // Adds 5 to the front of the list
        assertEquals(Integer.valueOf(5), list.getFirst()); // Ensures 5 is now the first element
    }

    /**
     * Tests that an element can be added to the end of the list
     * and verifies that it becomes the last element.
     */
    @Test
    public void testAddToEnd() {
        list.addToEnd(40); // Adds 40 to the end of the list
        assertEquals(Integer.valueOf(40), list.getLast()); // Ensures 40 is now the last element
    }

    /**
     * Tests removing an element from the list using a comparator.
     * Ensures that the list updates correctly after removal.
     */
    @Test
    public void testRemoveElement() {
        list.remove(20, Integer::compareTo); // Removes element 20 using a comparator
        assertEquals(Integer.valueOf(10), list.getFirst()); // Ensures 10 is still the first element
        assertEquals(Integer.valueOf(30), list.getLast()); // Ensures 30 is now the last element
    }

    /**
     * Tests the behavior of the iterator when attempting to go past the last element.
     * Ensures that a NoSuchElementException is thrown when calling next() beyond the list size.
     */
    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementException() {
        ListIterator<Integer> iterator = list.iterator(); // Gets an iterator for the list
        iterator.next(); iterator.next(); iterator.next(); // Moves to the last element
        iterator.next(); // Attempting to move past the last element should throw an exception
    }

    /**
     * Tests that the iterator does not support the remove() operation.
     * Ensures that calling remove() on the iterator throws an UnsupportedOperationException.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemoveUnsupportedOperation() {
        ListIterator<Integer> iterator = list.iterator(); // Gets an iterator for the list
        iterator.remove(); // Attempting to remove an element should throw an exception
    }
}
