package pt.pa.adts.queue;

/**
 * This class extends QueueLinkedList to disallow null elements.
 *
 * @param <T> the type of elements stored in the queue
 */
public class QueueLinkedListNoNulls<T> extends QueueLinkedList<T> {

    /**
     * Stores a new element in the rear of the queue.
     *
     * @param elem element to store
     * @throws QueueFullException thrown if there is no more capacity or memory for this element.
     * @throws NullNotAllowedException thrown if <i>elem</i> is <b>null</b>.
     */
    @Override
    public void enqueue(T elem) throws QueueFullException, NullNotAllowedException {
        if (elem == null) {
            throw new NullNotAllowedException("Null elements are not allowed"); // Throw exception for nulls
        }
        super.enqueue(elem); // Call the superclass method
    }
}
