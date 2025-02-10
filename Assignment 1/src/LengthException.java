/**
 * This Exception is thrown if the length of password is less than 6 characters.
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class LengthException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public LengthException() {
        super("Password must be at least 6 characters long.");
    }
}
