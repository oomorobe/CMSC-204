/**
 * This Exception is thrown if the password doesn’t contain at least one special character:
 * (!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~) 
 *
 * @author Okeoghene Excel Omorobe
 *
 */
public class NoSpecialCharacterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoSpecialCharacterException() {
        super("Password must include at least one special character.");
    }
}