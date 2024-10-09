package pt.pa.adts.queue;

/**
 * An exception that signals that the queue is empty.
 */
public class QueueEmptyException extends RuntimeException {

    public QueueEmptyException() {
        super("The queue is empty.");
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
