/**
 * This Exception is thrown if a dequeue method is called on an empty queue
 * 
 * @author Okeoghene Excel Omorobe
 *
 */

public class QueueUnderflowException extends RuntimeException {
	
	public QueueUnderflowException() {
		
		super("Queue is empty - QueueUnderflowException");
	}
	
	public QueueUnderflowException(String message) {
		super(message);
	}

}
