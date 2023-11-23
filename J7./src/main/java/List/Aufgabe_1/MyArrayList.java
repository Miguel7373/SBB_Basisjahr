package List.Aufgabe_1;


public class MyArrayList<E> implements MyListInterfaceSimple<E> {

    private Object[] data = new Object[1];
    private int size = 0;

    @Override
    public void add(E element) {
        if (size == data.length) {
            int newCapacity = data.length + 1;
            Object[] newData = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
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
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        data = new Object[1];
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += data[i];
            if (i < size - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}