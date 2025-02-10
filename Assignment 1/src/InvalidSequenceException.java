/**
 * This Exception is thrown if the password contains more than 2 of the same character in sequence
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class InvalidSequenceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidSequenceException() {
        super("Password cannot have more than two identical characters in a row.");
    }
}