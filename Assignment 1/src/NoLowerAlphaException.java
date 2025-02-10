/**
 * This Exception is thrown if the password doesn’t contain a lowercase alpha character
 * 
 * @author Okeoghene Excel Omorobe
 *
 */

public class NoLowerAlphaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoLowerAlphaException() {
        super("Password must include at least one lowercase letter.");
    }
}