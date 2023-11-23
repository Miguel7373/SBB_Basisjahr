package List.Aufgabe_2;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayListExtended<E> implements MyListInterfaceExtended<E> {
    private Object[] data = new Object[1];
    private int size = 0;

    @Override
    public void add(E element) {
        if (size == data.length) {
            int newCapacity = data.length + 1;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
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
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (size == data.length) {
            int newCapacity = data.length + 1;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        E replacedElement = get(index);
        data[index] = element;
        return replacedElement;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayListExtended that = (MyArrayListExtended) o;
        if (size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if ((data[i] == null && that.data[i] != null) || (data[i] != null)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            data[size - 1] = null;
            size--;
            return true;
        }
        throw new IndexOutOfBoundsException("Element not found");
    }
}
