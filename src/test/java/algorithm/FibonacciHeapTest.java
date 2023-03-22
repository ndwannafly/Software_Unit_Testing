package algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHeapTest {
    @Test
    public void testInsertAndPeek() {
        FibonacciHeap fibonacciHeap = new FibonacciHeap();
        fibonacciHeap.insert(5);
        fibonacciHeap.insert(3);
        fibonacciHeap.insert(1);
        fibonacciHeap.insert(18);
        fibonacciHeap.insert(33);

        assertEquals(fibonacciHeap.findMin().getKey(), 1);
        fibonacciHeap.deleteMin();
        assertEquals(fibonacciHeap.findMin().getKey(), 3);
    }

    @Test
    public void testRemove() {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);

        heap.deleteMin();
        assertEquals(20, heap.findMin().getKey());
    }

    @Test
    public void testSize() {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);

        assertEquals(3, heap.size());

        heap.deleteMin();
        assertEquals(2, heap.size());
    }

    @Test
    public void testEmptyHeap() {
        FibonacciHeap heap = new FibonacciHeap();

        assertTrue(heap.empty());

        assertThrows(IllegalStateException.class, heap::findMin);
        assertThrows(IllegalStateException.class, heap::deleteMin);
    }

    @Test
    public void testMergingHeaps() {
        FibonacciHeap heap1 = new FibonacciHeap();
        heap1.insert(10);
        heap1.insert(202);

        FibonacciHeap heap2 = new FibonacciHeap();
        heap2.insert(30);
        heap2.insert(40);

        heap1.merge(heap2);

        assertEquals(4, heap1.size());
        assertEquals(10, heap1.findMin().getKey());
    }

    @Test
    public void testDecreaseKey() {
        FibonacciHeap heap = new FibonacciHeap();
        FibonacciHeap.HeapNode entry1 = heap.insert(10);
        FibonacciHeap.HeapNode entry2 = heap.insert(20);

        heap.decreaseKey(entry2, 15);

        assertEquals(2, heap.size());
        assertEquals(5, heap.findMin().getKey());
    }

}