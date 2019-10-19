package test;

public class MyQueue<T> {
    private QueueNode first, last;

    private class QueueNode {
        private T data;
        private QueueNode next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    public void add(T item) {
        QueueNode t = new QueueNode(item);
        if (last != null) {
            last.next = t;
        }
        last = t;

        if (first == null) {
            first = last;
        }
    }

    public T remove() throws Exception {
        if (first == null)
            throw new Exception();
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() throws Exception {
        if (first == null)
            throw new Exception();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}