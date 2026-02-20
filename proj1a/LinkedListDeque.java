public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;

    private class TNode {
        private T item;
        private TNode next;
        private TNode prev;
        public TNode(TNode p, T i, TNode n) {
            this.item = i;
            this.next = n;
            this.prev = p;
        }
    }

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T i) {
        size = 1;
        sentinel = new TNode(null, null, null);
        sentinel.next = new TNode(sentinel, i, sentinel);
        sentinel.prev = sentinel.next;

    }

    public void  addFirst(T i) {
        size += 1;
        sentinel.next = new TNode(sentinel, i, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    public void  addLast(T i) {
        size += 1;
        sentinel.prev = new TNode(sentinel.prev, i, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (!isEmpty()) {
            TNode current = sentinel.next;
            for (int i = 0; i < size; i++) {
                System.out.print(current.item + " ");
                current = current.next;
            }
        }
    }

    public T removeFirst() {
        if (!isEmpty()) {
            T result = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return result;
        }
        return null;
    }

    public T removeLast() {
        if (!isEmpty()) {
            T result = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return result;
        }
        return null;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        TNode current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, TNode current) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return current.item;
        } else {
            current = current.next;
            return getRecursiveHelper(index - 1, current);
        }
    }

}