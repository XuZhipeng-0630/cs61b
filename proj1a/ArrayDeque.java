public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int boxsize;

    public ArrayDeque() {
        size = 0;
        boxsize = 8;
        items = (T[]) new Object[boxsize];
        nextFirst = 4;
        nextLast = 5;
    }

    private int minusOneIndex(int index) {
        return (index - 1 + boxsize) % boxsize;
    }

    private int plusOneIndex(int index) {
        return (index + 1) % boxsize;
    }

    public int firstIndex() {
        return plusOneIndex(nextFirst);
    }

    public int lastIndex() {
        return minusOneIndex(nextLast);
    }

    private void addOneResize() {
        if (size + 1 > boxsize) {
            T[] temp = (T[]) new Object[boxsize * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = items[(i + firstIndex()) % boxsize];
            }
            items = temp;
            boxsize *= 2;
            nextFirst = boxsize - 1;
            nextLast = size % boxsize;
        }
    }

    private void minusOneResize() {
        if ((boxsize > 8) && (size <= boxsize / 4)) {
            T[] temp = (T[]) new Object[boxsize / 2];
            for (int i = 0; i < size; i++) {
                temp[i] = items[(i + firstIndex()) % boxsize];
            }
            items = temp;
            boxsize /= 2;
            nextFirst = boxsize - 1;
            nextLast = size % boxsize;
        }
    }

    public void addFirst(T item) {
        addOneResize();
        items[nextFirst] = item;
        nextFirst = minusOneIndex(nextFirst);
        size++;
    }

    public void addLast(T item) {
        addOneResize();
        items[nextLast] = item;
        nextLast = plusOneIndex(nextLast);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(nextFirst + 1 + i) % boxsize] + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T result = items[firstIndex()];
        nextFirst = plusOneIndex(nextFirst);
        size--;
        minusOneResize();
        return result;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T result = items[lastIndex()];
        nextLast = minusOneIndex(nextLast);
        size--;
        minusOneResize();
        return result;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(firstIndex() + index) % boxsize];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        deque.addLast(9);
        deque.removeFirst();
        deque.removeLast();
        deque.printDeque();
    }
}
