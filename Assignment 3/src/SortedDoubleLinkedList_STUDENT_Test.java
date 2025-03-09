import static org.junit.Assert.*; // Importing JUnit assertion methods for testing
import java.util.Comparator; // Importing Comparator to compare elements in sorted order
import java.util.ListIterator; // Importing ListIterator for traversing the linked list
import org.junit.Before; // JUnit annotation to execute code before each test
import org.junit.Test; // JUnit annotation to define test methods

/**
 * JUnit test class for testing the SortedDoubleLinkedList implementation.
 * This class verifies correct behavior for adding elements in sorted order,
 * exception handling for restricted operations, and iterator traversal.
 */
public class SortedDoubleLinkedList_STUDENT_Test {
    private SortedDoubleLinkedList<Integer> sortedList; // A sorted doubly linked list of integers

    /**
     * This method runs before each test case. It initializes a SortedDoubleLinkedList
     * with a comparator that sorts integers in natural order and adds initial values.
     */
    @Before
    public void setUp() {
        sortedList = new SortedDoubleLinkedList<>(Integer::compareTo); // Initializes list with integer comparator
        sortedList.add(30); // Adding elements out of order to test sorting
        sortedList.add(10);
        sortedList.add(20);
    }

    /**
     * Tests that elements are correctly inserted into the sorted linked list.
     * Verifies that the elements are in ascending order when iterated over.
     */
    @Test
    public void testAddSorted() {
        sortedList.add(25); // Adding a new element (should be inserted in correct position)
        ListIterator<Integer> iterator = sortedList.iterator(); // Obtains an iterator to traverse the list

        // Checking if the list maintains sorted order
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(20), iterator.next());
        assertEquals(Integer.valueOf(25), iterator.next());
        assertEquals(Integer.valueOf(30), iterator.next());
    }

    /**
     * Tests that calling addToFront() throws an UnsupportedOperationException.
     * Since the list is sorted, adding directly to the front is not allowed.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testAddToFrontException() {
        sortedList.addToFront(5); // This should throw an exception
    }

    /**
     * Tests that calling addToEnd() throws an UnsupportedOperationException.
     * Since the list is sorted, adding directly to the end is not allowed.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testAddToEndException() {
        sortedList.addToEnd(50); // This should throw an exception
    }

    /**
     * Tests if the iterator correctly traverses the sorted linked list in order.
     */
    @Test
    public void testIteratorTraversal() {
        ListIterator<Integer> iterator = sortedList.iterator(); // Obtains an iterator

        // Checking if the iterator correctly goes through elements in sorted order
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(20), iterator.next());
        assertEquals(Integer.valueOf(30), iterator.next());
    }
}
