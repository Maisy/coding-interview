package test;

public class MyStack<T> {

    private StackNode top;

    private class StackNode {
        private T data;
        private StackNode next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    public T pop() throws Exception {
        if (top == null)
            throw new Exception();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public T peek() throws Exception {
        if (top == null)
            throw new Exception();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}