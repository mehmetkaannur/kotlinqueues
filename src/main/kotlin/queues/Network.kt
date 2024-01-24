package queues

interface Acceptor<T> {
    fun accept(obj: T)
}

interface Forwarder {
    fun forward()
}

class QueueNode<T>(
    private val queue: Queue<T>,
    private val successor: Acceptor<T>,
) : Acceptor<T>, Forwarder {
    override fun accept(obj: T) {
        queue.enqueue(obj)
    }

    override fun forward() {
        val succ = queue.dequeue()

    }
}
