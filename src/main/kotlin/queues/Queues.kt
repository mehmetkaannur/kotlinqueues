package queues // ktlint-disable filename

interface Queue<T> {
    fun enqueue(obj: T)
    fun peek(): T?
    fun dequeue(): T
    fun isEmpty(): Boolean
    fun size(): Int
}

class FifoQueue<T> : Queue<T> {

    private var list: MutableList<T> = mutableListOf()
    override fun enqueue(obj: T) {
        list.add(obj)
    }

    override fun peek(): T? {
        return if (isEmpty()) {
            null
        } else {
            list[0]
        }
    }

    override fun dequeue(): T {
        val first = list[0]
        list.removeAt(0)
        return first
    }

    override fun isEmpty(): Boolean = list.size == 0

    override fun size(): Int = list.size
}

class LifoQueue<T> : Queue<T> {
    private var list: MutableList<T> = mutableListOf()
    override fun enqueue(obj: T) {
        list.add(obj)
    }

    override fun peek(): T? {
        return if (isEmpty()) {
            null
        } else {
            list[list.lastIndex]
        }
    }

    override fun dequeue(): T {
        val last = list[list.lastIndex]
        list.removeAt(list.lastIndex)
        return last
    }

    override fun isEmpty(): Boolean = list.size == 0

    override fun size(): Int = list.size
}
