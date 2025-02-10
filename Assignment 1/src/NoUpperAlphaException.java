/**
 * This Exception is thrown if the password doesn’t contain an uppercase alpha character 
 * 
 * @author Okeoghene Excel Omorobe
 *
 */
public class NoUpperAlphaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoUpperAlphaException() {
        super("Password must include at least one uppercase letter.");
    }
}