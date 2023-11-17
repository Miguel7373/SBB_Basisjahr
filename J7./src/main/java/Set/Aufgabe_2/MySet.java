package Set.Aufgabe_2;

public class MySet<E> implements MySetInterfaceSimple<E> {
    private Object[] elements;
    private int size;

    public MySet() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public boolean add(E element) {
        if (!contains(element)) {
            if (size == elements.length) {
                int newCapacity = elements.length * 2;
                Object[] newElements = new Object[newCapacity];
                for (int i = 0; i < size; i++) {
                    newElements[i] = elements[i];
                }
                elements = newElements;
            }
            elements[size++] = element;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == element) ){
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if ((elements[i] == null && element == null) || (elements[i] != null && elements[i].equals(element))) {
                return true;
            }
        }
        return false;
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
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }

        String result = String.valueOf(elements[0]);
        for (int i = 1; i < size; i++) {
            result += ", " + elements[i];
        }
        return result;
    }
}
