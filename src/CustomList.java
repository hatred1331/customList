

public class CustomList<T> {

    private T[] elements;
    private int size;

    public CustomList() {
        this(10); // initial capacity
    }

    public CustomList(int initialCapacity) {
        elements = (T[]) new Object[initialCapacity];
        size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            T[] newElements = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = element;
    }

    public void addAll(CustomList<T> c) {
        if (c == null) {
            throw new NullPointerException();
        }

        int numNew = c.size();
        if (numNew == 0) {
            throw new IndexOutOfBoundsException();
        }

        int newSize = size + numNew;
        if (newSize > elements.length) {
            // resize array
            int newCapacity = (int) (elements.length * 1.5) + 1;
            if (newCapacity < newSize) {
                newCapacity = newSize;
            }
            T[] newElements = (T[]) new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }

        for (int i = 0; i < numNew; i++) {
            elements[size + i] = c.elements[i];
        }

        size = newSize;


    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public void sort() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < size - 1; i++) {
                if (((Comparable<T>) elements[i]).compareTo(elements[i + 1]) > 0) {
                    T temp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

