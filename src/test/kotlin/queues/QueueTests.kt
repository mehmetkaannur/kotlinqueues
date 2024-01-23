package queues

import kotlin.test.Test
import kotlin.test.assertEquals

class FifoQueueTests {
    @Test
    fun `queue implements FIFO for Int`() {
        val fifoQueue = FifoQueue<Int>()

        fifoQueue.enqueue(1)
        fifoQueue.enqueue(3)
        fifoQueue.enqueue(2)
        assertEquals(1, fifoQueue.dequeue())
        assertEquals(3, fifoQueue.dequeue())
        assertEquals(2, fifoQueue.dequeue())
    }

    // TODO: add comprehensive tests for the FifoQueue<T> class.
    @Test
    fun `student queue implements FIFO for String`() {
        val fifoQueue = FifoQueue<String>()

        fifoQueue.enqueue("a")
        assertEquals(false, fifoQueue.isEmpty())
        fifoQueue.dequeue()
        assertEquals(true, fifoQueue.isEmpty())
    }
}

class LifoQueueTests {
    @Test
    fun `queue implements LIFO for Int`() {
        val lifoQueue = LifoQueue<Int>()

        lifoQueue.enqueue(1)
        lifoQueue.enqueue(3)
        lifoQueue.enqueue(2)
        assertEquals(2, lifoQueue.dequeue())
        assertEquals(3, lifoQueue.dequeue())
        assertEquals(1, lifoQueue.dequeue())
    }

    // TODO: add comprehensive tests for the LifoQueue<T> class.
    @Test
    fun `student queue implements LIFO for Boolean`() {
        val fifoQueue = FifoQueue<Boolean>()

        fifoQueue.enqueue(true)
        fifoQueue.enqueue(false)
        fifoQueue.enqueue(false)
        assertEquals(3, fifoQueue.size())
    }
}

class PrQueueTests {
    @Test
    fun `queue implements Priority for Int`() {
        val prQueue = PrQueue<Int>()

        prQueue.enqueue(1)
        prQueue.enqueue(3)
        prQueue.enqueue(2)
        assertEquals(1, prQueue.dequeue())
        assertEquals(2, prQueue.dequeue())
        assertEquals(3, prQueue.dequeue())
    }

    // TODO: add comprehensive tests for the PrQueue<T> class.

    @Test
    fun `student queue implements Priority for String`() {
        val prQueue = PrQueue<String>()

        prQueue.enqueue("a")
        prQueue.enqueue("c")
        prQueue.enqueue("b")
        assertEquals("a", prQueue.dequeue())
        assertEquals("b", prQueue.dequeue())
        assertEquals("c", prQueue.dequeue())
    }

    @Test
    fun `queue implements Priority for Point`() {
        val prQueue = PrQueue<Point>()

        prQueue.enqueue(Point(2, 2))
        prQueue.enqueue(Point(1, 1))
        prQueue.enqueue(Point(0, 1))
        prQueue.enqueue(Point(1, 2))
        prQueue.enqueue(Point(0, 2))
        prQueue.enqueue(Point(1, 0))
        prQueue.enqueue(Point(2, 0))
        prQueue.enqueue(Point(0, 0))
        prQueue.enqueue(Point(2, 1))

        assertEquals(Point(0, 0), prQueue.dequeue())
        assertEquals(Point(0, 1), prQueue.dequeue())
        assertEquals(Point(0, 2), prQueue.dequeue())
        assertEquals(Point(1, 0), prQueue.dequeue())
        assertEquals(Point(1, 1), prQueue.dequeue())
        assertEquals(Point(1, 2), prQueue.dequeue())
        assertEquals(Point(2, 0), prQueue.dequeue())
        assertEquals(Point(2, 1), prQueue.dequeue())
        assertEquals(Point(2, 2), prQueue.dequeue())
    }
}

data class Point(val coordX: Int, val coordY: Int)
