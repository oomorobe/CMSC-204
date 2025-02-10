/**
 * This Exception is thrown if the password doesn’t contain a numeric character
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class NoDigitException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoDigitException() {
        super("Password must include at least one number.");
    }
}
