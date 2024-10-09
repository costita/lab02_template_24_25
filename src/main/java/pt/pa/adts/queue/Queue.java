package pt.pa.adts.queue;

/**
 * Specifies the behavior of a queue.
 *
 * A queue is a container which provides a first-in-first-out access model.
 *
 * @param <T> type of elements stored in the queue.
 */
public interface Queue<T> {

    void enqueue(T elem) throws QueueFullException, NullNotAllowedException;

    T dequeue() throws QueueEmptyException;

    T front() throws QueueEmptyException;

    int size();

    boolean isEmpty();

    void clear();
}
