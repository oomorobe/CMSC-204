import java.util.ArrayList;

/**
 * @author Okeoghene Excel Omorobe
 * MyStack is a generic stack implementation using an ArrayList.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class MyStack<T> implements StackInterface<T> {
    private ArrayList<T> stack; // List to store stack elements
    private int capacity;       // Maximum number of elements the stack can hold

    /**
     * Constructor that allows specifying the stack's capacity.
     *
     * @param size The maximum number of elements the stack can hold.
     */
    public MyStack(int size) {
        this.capacity = size;
        this.stack = new ArrayList<>(size);
    }

    /**
     * Default constructor that sets the stack's capacity to 10.
     */
    public MyStack() {
        this.capacity = 10;
        this.stack = new ArrayList<>(capacity);
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack has no elements, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack has reached its capacity, false otherwise.
     */
    @Override
    public boolean isFull() {
        return stack.size() == capacity;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException(); // Can't pop from an empty stack
        }
        return stack.remove(stack.size() - 1); // Remove and return the last element (LIFO)
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    @Override
    public T top() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException(); // Can't peek at an empty stack
        }
        return stack.get(stack.size() - 1); // Return the last element without removing it
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return The number of elements in the stack.
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param e The element to be added.
     * @return true if the element was added successfully.
     * @throws StackOverflowException If the stack is full.
     */
    @Override
    public boolean push(T e) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException(); // Can't push onto a full stack
        }
        return stack.add(e); // Add element to the end (top of the stack)
    }

    /**
     * Returns a string representation of the stack, concatenating elements without a delimiter.
     *
     * @return A string with all elements combined.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : stack) {
            sb.append(item); // Append each element to the StringBuilder
        }
        return sb.toString();
    }

    /**
     * Returns a string representation of the stack, separating elements with the specified delimiter.
     *
     * @param delimiter The delimiter used between elements.
     * @return A string with elements separated by the delimiter.
     */
    @Override
    public String toString(String delimiter) {
        // Convert each element to a string, then join them using the delimiter
        return String.join(delimiter, stack.stream().map(Object::toString).toArray(String[]::new));
    }

    /**
     * Clears the current stack and fills it with elements from the provided list.
     * If the list has more elements than the stack's capacity, a StackOverflowException is thrown.
     *
     * @param list The list of elements to add to the stack.
     * @throws StackOverflowException If the stack becomes full before all elements are added.
     */
    @Override
    public void fill(ArrayList<T> list) {
        stack.clear(); // Remove all current elements
        for (T item : list) {
            if (!isFull()) {
                stack.add(item); // Add elements until the stack is full
            } else {
                throw new StackOverflowException(); // Stop if capacity is exceeded
            }
        }
    }
}
