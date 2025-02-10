public class WeakPasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public WeakPasswordException() {
        super("Password is valid but weak - it has fewer than 10 characters.");
    }
}