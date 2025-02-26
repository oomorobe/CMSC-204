/**
 * This Exception is thrown if an enqueue method is called on a full queue
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class QueueOverflowException extends RuntimeException {
	
	public QueueOverflowException() {
		super("Queue is full - QueueOverflowException");
	}
	
	public QueueOverflowException(String message) {
		super(message);
	}

}
