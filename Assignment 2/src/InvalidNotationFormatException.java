/**
 * This Exception is thrown if the Notation format is incorrect
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class InvalidNotationFormatException extends Exception {
	
	public InvalidNotationFormatException() {
		super ("Invalid notation format");
	}
	
	public InvalidNotationFormatException(String message) {
		super(message);
	}

}
