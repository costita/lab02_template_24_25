package pt.pa.adts.queue;

/**
 * An exception that signals that null elements are not allowed.
 */
public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        super("Null elements are not allowed.");
    }

    public NullNotAllowedException(String message) {
        super(message);
    }
}
