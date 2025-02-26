/**
 * This Exception is thrown if a pop or top method is called on an empty stack
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class StackUnderflowException extends RuntimeException {
	
	public StackUnderflowException() {
		super("Stack is empty - StackUnderflowException");
	}
	
	public StackUnderflowException(String message) {
		super(message);
	}

}
