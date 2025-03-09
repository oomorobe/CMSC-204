import java.util.Comparator;

/**
 * A sorted version of the doubly linked list.
 * Elements are always inserted in sorted order based on a given comparator.
 *
 * @param <T> The type of elements stored in the list.
 */
/**
 * Implements a generic sorted double list using a provided Comparator. It extends
 * BasicDoubleLinkedList class.
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator; // Comparator to maintain sorting order.

    /**
     * Constructor to initialize the sorted doubly linked list with a comparator.
     *
     * @param comparator The comparator used for sorting elements.
     */
    public SortedDoubleLinkedList(Comparator<T> comparator) {
        super(); // Call the constructor of BasicDoubleLinkedList.
        this.comparator = comparator;
    }

    /**
     * Adds a new element into the list while maintaining the sorted order.
     *
     * @param data The data to be inserted.
     */
    public void add(T data) {
        Node newNode = new Node(data); // Create a new node.
        
        if (head == null) { // If the list is empty, set head and tail to the new node.
            head = tail = newNode;
        } else {
            Node current = head;

            // Traverse the list to find the correct position for insertion.
            while (current != null && comparator.compare(current.data, data) < 0) {
                current = current.next;
            }

            if (current == head) { // Insert at the beginning if data is the smallest.
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) { // Insert at the end if data is the largest.
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else { // Insert in the middle of the list.
                newNode.next = current;
                newNode.prev = current.prev;
                if (current.prev != null) {
                current.prev.next = newNode;
                }
                current.prev = newNode;
            }
        }
        size++; // Increment the size of the list.
    }

    /**
     * Unsupported operation for a sorted list.
     * Prevents adding elements arbitrarily to the front.
     *
     * @param data The data to be added.
     * @throws UnsupportedOperationException Always thrown when called.
     */
    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    /**
     * Unsupported operation for a sorted list.
     * Prevents adding elements arbitrarily to the end.
     *
     * @param data The data to be added.
     * @throws UnsupportedOperationException Always thrown when called.
     */
    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
}
