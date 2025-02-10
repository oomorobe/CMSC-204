public class UnmatchedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnmatchedException() {
        super("Passwords do not match.");
    }
}