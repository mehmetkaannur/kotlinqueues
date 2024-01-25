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
        successor.accept(succ)
    }
}

class Sink<T> : Acceptor<T> {
    private var list: MutableList<T> = mutableListOf()
    override fun accept(obj: T) {
        list.add(obj)
    }

    fun getAccepted(): MutableList<T> {
        return list
    }
}
