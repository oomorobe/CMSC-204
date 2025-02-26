/**
 * This Exception is thrown if a push method is called on a full stack
 * 
 * @author Okeoghene Excel Omorobe
 *
 */

public class StackOverflowException extends RuntimeException {
	
	public StackOverflowException() {
		super("Stack is full - StackOverflowException");
	}
	
	public StackOverflowException(String message) {
		super(message);
	}

}
