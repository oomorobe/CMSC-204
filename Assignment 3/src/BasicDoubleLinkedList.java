import java.util.*;

/**
 * A basic implementation of a doubly linked list.
 * @param <T> The type of elements stored in the list.
 */
/**
 * This generic double-linked list relies on a head (reference to first element of the list) and
 * tail (reference to the last element of the list). Both are set to null when the list is empty.
 * Both point to the same element when there is only one element in the list. A node structure has
 * only three fields: data and the prev and next references. The class must only define the
 * following entities: an inner class Node, an inner class that implements ListIterator (for the
 * iterator method), head and tail references and an integer representing the list size. However
 * only the hasNext(), next(), hasPrevious() and previous() methods of ListIterator need to be
 * implemented, all other methods can throw the UnsupportedOperationException. All the entities are
 * defined as protected so they can be accessed by the subclasses.
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

    /**
     * A nested class representing a node in the doubly linked list.
     */
    protected class Node {
        T data; // Data stored in the node.
        Node prev, next; // Pointers to the previous and next nodes.

        /**
         * Constructor to initialize a new node with given data.
         * @param data The value to store in the node.
         */
        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    protected Node head, tail; // Pointers to the first and last nodes in the list.
    protected int size; // Tracks the number of elements in the list.

    /**
     * Constructor to initialize an empty doubly linked list.
     */
    public BasicDoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    /**
     * Adds a new element to the front (beginning) of the list.
     * @param data The data to be added.
     * @throws IllegalArgumentException If the provided data is null.
     */
    public void addToFront(T data) {
        if (data == null) throw new IllegalArgumentException("Data cannot be null");
        Node newNode = new Node(data);
        if (head == null) { // If the list is empty, head and tail point to the new node.
            head = tail = newNode;
        } else { // Otherwise, update the head pointer.
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds a new element to the end (tail) of the list.
     * @param data The data to be added.
     * @throws IllegalArgumentException If the provided data is null.
     */
    public void addToEnd(T data) {
        if (data == null) throw new IllegalArgumentException("Data cannot be null");
        Node newNode = new Node(data);
        if (tail == null) { // If the list is empty, head and tail point to the new node.
            head = tail = newNode;
        } else { // Otherwise, update the tail pointer.
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Retrieves the first element in the list without removing it.
     * @return The first element.
     * @throws NoSuchElementException If the list is empty.
     */
    public T getFirst() {
        if (head == null) throw new NoSuchElementException("List is empty");
        return head.data;
    }

    /**
     * Retrieves the last element in the list without removing it.
     * @return The last element.
     * @throws NoSuchElementException If the list is empty.
     */
    public T getLast() {
        if (tail == null) throw new NoSuchElementException("List is empty");
        return tail.data;
    }

    /**
     * Removes and returns the first element from the list.
     * @return The removed element.
     * @throws NoSuchElementException If the list is empty.
     */
    public T retrieveFirstElement() {
        if (head == null) throw new NoSuchElementException("List is empty");
        T data = head.data;
        head = head.next; // Move the head pointer forward.
        if (head != null) {
            head.prev = null; // Disconnect the previous head.
        } else {
            tail = null; // If the list becomes empty, update tail as well.
        }
        size--;
        return data;
    }

    /**
     * Removes and returns the last element from the list.
     * @return The removed element.
     * @throws NoSuchElementException If the list is empty.
     */
    public T retrieveLastElement() {
        if (tail == null) throw new NoSuchElementException("List is empty");
        T data = tail.data;
        tail = tail.prev; // Move the tail pointer backward.
        if (tail != null) {
            tail.next = null; // Disconnect the previous tail.
        } else {
            head = null; // If the list becomes empty, update head as well.
        }
        size--;
        return data;
    }

    /**
     * Removes the first occurrence of a specified element from the list.
     * @param target The element to remove.
     * @param comparator The comparator to determine equality.
     * @throws IllegalArgumentException If target or comparator is null.
     * @throws NoSuchElementException If the element is not found.
     */
    public void remove(T target, Comparator<T> comparator) {
        if (target == null || comparator == null) throw new IllegalArgumentException("Arguments cannot be null");
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, target) == 0) { // Check if current node matches the target.
                if (current == head) head = current.next; // Update head if the first node is removed.
                if (current == tail) tail = current.prev; // Update tail if the last node is removed.
                if (current.prev != null) current.prev.next = current.next; // Update previous node’s next pointer.
                if (current.next != null) current.next.prev = current.prev; // Update next node’s previous pointer.
                size--;
                return; // Stop after the first occurrence is removed.
            }
            current = current.next; // Move to the next node.
        }
        throw new NoSuchElementException("Element not found in the list");
    }

    /**
     * Converts the linked list into an ArrayList.
     * @return An ArrayList containing all elements of the list.
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) { // Traverse the list and add elements to the ArrayList.
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    /**
     * A private class implementing a ListIterator for traversing the doubly linked list.
     */
    private class DoubleLinkedListIterator implements ListIterator<T> {
        private Node current;
        private int index = 0;

        public DoubleLinkedListIterator() {
            this.current = head;
        }

        public boolean hasNext() {
            return current != null; //&& current.next != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException("No more elements in the list");
            T data = current.data;
            current = current.next;
            index++;
            return data;
        }

        public boolean hasPrevious() {
            return current != null && current.prev != null;
        }

        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException("No previous elements in the list");
            current = current.prev;
            index--;
            return current.data;
        }

        public int nextIndex() {
            return hasNext() ? index + 1 : size;
        }

        public int previousIndex() {
            return hasPrevious() ? index - 1 : -1;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported");
        }

        public void set(T e) {
            throw new UnsupportedOperationException("Set operation is not supported");
        }

        public void add(T e) {
            throw new UnsupportedOperationException("Add operation is not supported");
        }
    }

    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    public int getSize() {
        return size;
    }
}
