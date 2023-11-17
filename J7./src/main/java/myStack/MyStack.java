package myStack;

import java.util.EmptyStackException;
import java.util.Arrays;

public class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyStack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public E push(E item) {
        ensureCapacity();
        array[size++] = item;
        return item;
    }

    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E item = peek();
        array[--size] = null; // dereference the popped element
        return item;
    }

    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return (E) array[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("blue");
        stack.push("yellow");
        stack.push("green");
        stack.push("orange");

        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Empty: " + stack.empty());
    }
}

