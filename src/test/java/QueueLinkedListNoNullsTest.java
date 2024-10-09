import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pt.pa.adts.queue.NullNotAllowedException;
import pt.pa.adts.queue.QueueEmptyException;
import pt.pa.adts.queue.QueueLinkedListNoNulls;

public class QueueLinkedListNoNullsTest {

    @Test
    public void testEnqueueNullThrowsException() {
        QueueLinkedListNoNulls<Integer> queue = new QueueLinkedListNoNulls<>();
        Exception exception = Assertions.assertThrows(NullNotAllowedException.class, () -> {
            queue.enqueue(null); // Try to enqueue null
        });

        Assertions.assertEquals("Null elements are not allowed", exception.getMessage()); // Check the message
    }

    @Test
    public void testDequeueThrowsExceptionOnEmptyQueue() {
        QueueLinkedListNoNulls<Integer> queue = new QueueLinkedListNoNulls<>();
        Assertions.assertThrows(QueueEmptyException.class, queue::dequeue); // Try to dequeue from an empty queue
    }

    @Test
    public void testFrontThrowsExceptionOnEmptyQueue() {
        QueueLinkedListNoNulls<Integer> queue = new QueueLinkedListNoNulls<>();
        Assertions.assertThrows(QueueEmptyException.class, queue::front); // Try to access front of an empty queue
    }

    @Test
    public void testSizeAfterEnqueueAndDequeue() {
        QueueLinkedListNoNulls<Integer> queue = new QueueLinkedListNoNulls<>();
        Assertions.assertEquals(0, queue.size()); // Check initial size

        queue.enqueue(1);
        Assertions.assertEquals(1, queue.size()); // Check size after one enqueue

        queue.enqueue(2);
        Assertions.assertEquals(2, queue.size()); // Check size after two enqueues

        queue.dequeue();
        Assertions.assertEquals(1, queue.size()); // Check size after one dequeue
    }

    @Test
    public void testIsEmpty() {
        QueueLinkedListNoNulls<Integer> queue = new QueueLinkedListNoNulls<>();
        Assertions.assertTrue(queue.isEmpty()); // Check if queue is empty initially

        queue.enqueue(1);
        Assertions.assertFalse(queue.isEmpty()); // Check if queue is not empty after one enqueue

        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty()); // Check if queue is empty again after dequeue
    }

    @Test
    public void testClear() {
        QueueLinkedListNoNulls<Integer> queue = new QueueLinkedListNoNulls<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.clear();
        Assertions.assertTrue(queue.isEmpty()); // Check if queue is empty after clearing
        Assertions.assertEquals(0, queue.size()); // Check if size is 0 after clearing
    }
}
