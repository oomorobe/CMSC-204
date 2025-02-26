import java.util.ArrayList;

/**
 * @author Okeoghene Excel Omorobe
 * MyQueue is a generic queue implementation using an ArrayList.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class MyQueue<T> implements QueueInterface<T> {
    private ArrayList<T> queue; // List to store queue elements
    private int capacity;       // Maximum number of elements the queue can hold

    /**
     * Constructor that allows specifying the queue's capacity.
     *
     * @param size The maximum number of elements the queue can hold.
     */
    public MyQueue(int size) {
        this.capacity = size;
        this.queue = new ArrayList<>(size);
    }

    /**
     * Default constructor that sets the queue's capacity to 10.
     */
    public MyQueue() {
        this.capacity = 10;
        this.queue = new ArrayList<>(capacity);
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue has no elements, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue has reached its capacity, false otherwise.
     */
    @Override
    public boolean isFull() {
        return queue.size() == capacity;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return The element at the front of the queue.
     * @throws QueueUnderflowException If the queue is empty.
     */
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException(); // Can't dequeue from an empty queue
        }
        return queue.remove(0); // Remove the first element (FIFO)
    }

    /**
     * Returns the number of elements currently in the queue.
     *
     * @return The number of elements in the queue.
     */
    @Override
    public int size() {
        return queue.size();
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param e The element to be added.
     * @return true if the element was added successfully.
     * @throws QueueOverflowException If the queue is full.
     */
    @Override
    public boolean enqueue(T e) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException(); // Can't add to a full queue
        }
        return queue.add(e); // Add element at the end
    }

    /**
     * Returns a string representation of the queue, concatenating elements without a delimiter.
     *
     * @return A string with all elements combined.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : queue) {
            sb.append(item); // Append each element to the StringBuilder
        }
        return sb.toString();
    }

    /**
     * Returns a string representation of the queue, separating elements with the specified delimiter.
     *
     * @param delimiter The delimiter used between elements.
     * @return A string with elements separated by the delimiter.
     */
    @Override
    public String toString(String delimiter) {
        // Convert each element to a string, then join them using the delimiter
        return String.join(delimiter, queue.stream().map(Object::toString).toArray(String[]::new));
    }

    /**
     * Clears the current queue and fills it with elements from the provided list.
     * If the list has more elements than the queue's capacity, a QueueOverflowException is thrown.
     *
     * @param list The list of elements to add to the queue.
     * @throws QueueOverflowException If the queue becomes full before all elements are added.
     */
    @Override
    public void fill(ArrayList<T> list) {
        queue.clear(); // Remove all current elements
        for (T item : list) {
            if (!isFull()) {
                queue.add(item); // Add elements until the queue is full
            } else {
                throw new QueueOverflowException(); // Stop if capacity is exceeded
            }
        }
    }
}
