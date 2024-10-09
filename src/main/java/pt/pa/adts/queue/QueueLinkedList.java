package pt.pa.adts.queue;

/**
 * This class implements the Queue interface using a doubly linked list with sentinels.
 *
 * @param <T> the type of elements stored in the queue
 */
public class QueueLinkedList<T> implements Queue<T> {

    private ListNode header, trailer; // Sentinels
    private int size; // Number of elements in the queue

    /**
     * Constructs an empty queue.
     */
    public QueueLinkedList() {
        header = new ListNode(null, null, null);
        trailer = new ListNode(null, header, null);
        header.next = trailer;
        size = 0;
    }

    /**
     * Stores a new element in the rear of the queue.
     *
     * @param elem element to store
     * @throws QueueFullException thrown if there is no more capacity or memory for this element.
     * @throws NullNotAllowedException thrown if <i>elem</i> is <b>null</b> and the implementation does not allow nulls.
     */
    @Override
    public void enqueue(T elem) throws QueueFullException, NullNotAllowedException {
        if (elem == null) {
            throw new NullNotAllowedException("Null elements are not allowed");
        }

        ListNode newNode = new ListNode(elem, trailer.prev, trailer); // Create new node
        trailer.prev.next = newNode; // Link previous to new node
        trailer.prev = newNode; // Link new node to trailer
        size++; // Increment size
    }

    /**
     * Removes the element at the front of the queue.
     *
     * @return element at the front
     * @throws QueueEmptyException thrown if the queue is empty.
     */
    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException(); // Throw exception if queue is empty
        }
        T element = header.next.element; // Get the element at the front
        header.next = header.next.next; // Remove the element from the queue
        header.next.prev = header; // Update the previous pointer
        size--; // Decrement size
        return element; // Return the removed element
    }

    /**
     * Returns a reference to the element at the front of the queue.
     *
     * @return element at the front
     * @throws QueueEmptyException thrown if the queue is empty.
     */
    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException(); // Throw exception if queue is empty
        }
        return header.next.element; // Return the front element
    }

    /**
     * The number of elements stored in the queue.
     *
     * @return element count.
     */
    @Override
    public int size() {
        return size; // Return the current size of the queue
    }

    /**
     * Whether the queue is empty or not.
     *
     * @return <i>true</i> if the queue is empty; <i>false</i> otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // Return true if the queue is empty
    }

    /**
     * Clears the contents of the queue, returning to an empty state.
     */
    @Override
    public void clear() {
        header.next = trailer; // Link header directly to trailer
        trailer.prev = header; // Link trailer directly to header
        size = 0; // Reset size
    }

    /**
     * Inner class to represent a node in the doubly linked list.
     */
    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
