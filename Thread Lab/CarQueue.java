import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * CarQueue simulates a queue of cars approaching an intersection.
 * Each car has a direction represented by an integer (0 to 3).
 * @author Okeoghene Excel Omorobe
 */
public class CarQueue {
    private Queue<Integer> queue; // Queue to hold car directions
    private Random rand;          // Random number generator

    /**
     * Constructor initializes the queue with 6 cars,
     * each assigned a random direction from 0 to 3.
     */
    public CarQueue() {
        queue = new LinkedList<>();
        rand = new Random();

        // Add 6 cars with random directions (0 to 3)
        for (int i = 0; i < 6; i++) {
            queue.add(rand.nextInt(4)); // 0 = North, 1 = East, 2 = South, 3 = West (example meanings)
        }
    }

    /**
     * Continuously adds a new car with a random direction to the queue every second.
     * This runs in a background thread.
     */
    public void addToQueue() {
        class QueueRunnable implements Runnable {
            public void run() {
                try {
                    while (true) {
                        queue.add(rand.nextInt(4)); // Add a car with a random direction
                        Thread.sleep(1000); // Wait for 1 second before adding the next car
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Handle interruption gracefully
                }
            }
        }

        // Start the queue populator in a separate thread
        Thread t = new Thread(new QueueRunnable());
        t.start();
    }

    /**
     * Removes and returns the direction of the car at the front of the queue.
     * If the queue is empty, it returns 2 (defaulting to "South" or "right").
     */
    public int deleteQueue() {
        if (queue.isEmpty()) {
            return 2; // Default direction if queue is empty
        }
        return queue.remove(); // Remove and return the head of the queue
    }
}
