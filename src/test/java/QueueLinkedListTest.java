import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pa.adts.queue.QueueEmptyException;
import pt.pa.adts.queue.QueueLinkedList;

public class QueueLinkedListTest {

    private QueueLinkedList<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueLinkedList<>();  // Inicializa a fila antes de cada teste
    }

    @Test
    public void testFIFOPrinciple() {
        // Testa o princípio FIFO
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue(), "Deve retornar o primeiro elemento adicionado");
        assertEquals(2, queue.dequeue(), "Deve retornar o segundo elemento adicionado");
        assertEquals(3, queue.dequeue(), "Deve retornar o terceiro elemento adicionado");
    }

    @Test
    public void testDequeueThrowsExceptionOnEmptyQueue() {
        // Testa se a exceção é lançada ao tentar remover da fila vazia
        assertThrows(QueueEmptyException.class, () -> {
            queue.dequeue();
        }, "Deve lançar QueueEmptyException ao tentar fazer dequeue em uma fila vazia");
    }

    @Test
    public void testFrontThrowsExceptionOnEmptyQueue() {
        // Testa se a exceção é lançada ao tentar acessar o front da fila vazia
        assertThrows(QueueEmptyException.class, () -> {
            queue.front();
        }, "Deve lançar QueueEmptyException ao tentar acessar front em uma fila vazia");
    }

    @Test
    public void testSizeAfterEnqueueAndDequeue() {
        // Testa o método size()
        assertEquals(0, queue.size(), "A fila deve estar vazia inicialmente");

        queue.enqueue(1);
        assertEquals(1, queue.size(), "A fila deve conter 1 elemento");

        queue.enqueue(2);
        assertEquals(2, queue.size(), "A fila deve conter 2 elementos");

        queue.dequeue();
        assertEquals(1, queue.size(), "A fila deve conter 1 elemento após uma remoção");
    }

    @Test
    public void testSizeAfterClear() {
        // Testa o método size() após clear()
        queue.enqueue(1);
        queue.enqueue(2);
        queue.clear();
        assertEquals(0, queue.size(), "A fila deve estar vazia após clear()");

        queue.clear();  // Testa clear() em fila já vazia
        assertEquals(0, queue.size(), "A fila deve continuar vazia após novo clear()");
    }

    @Test
    public void testIsEmpty() {
        // Testa o método isEmpty()
        assertTrue(queue.isEmpty(), "A fila deve estar vazia inicialmente");

        queue.enqueue(1);
        assertFalse(queue.isEmpty(), "A fila não deve estar vazia após enqueue()");

        queue.dequeue();
        assertTrue(queue.isEmpty(), "A fila deve estar vazia após dequeue()");
    }

    @Test
    public void testIsEmptyAfterClear() {
        // Testa isEmpty() após clear()
        queue.enqueue(1);
        queue.clear();
        assertTrue(queue.isEmpty(), "A fila deve estar vazia após clear()");

        queue.clear();  // Testa clear() em fila já vazia
        assertTrue(queue.isEmpty(), "A fila deve continuar vazia após novo clear()");
    }
}
