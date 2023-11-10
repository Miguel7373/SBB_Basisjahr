package List.Aufgabe_1;
import java.util.Arrays;


public class MyArrayList<E> implements MyListInterfaceSimple<E> {

    private Object[] data = new Object[10];
    private int size = 0;

    @Override
    public void add(E element) {
        ensureCapacity();
        data[size++] = element;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (E) data[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        E removedElement = (E) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void clear() {
        data = new Object[10];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}