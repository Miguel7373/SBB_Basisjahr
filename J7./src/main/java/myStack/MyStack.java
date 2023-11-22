package myStack;

import java.util.EmptyStackException;


public class MyStack<E> implements MyStackInterface<E>{
    private Object[] array = new Object[1];
    private int size = 0;

    public E push(E item) {
            Object[] newArray = new Object[array.length + 1];
            for (int i = size - 1; i >= 0; i--) {
                newArray[i + 1] = array[i];
            }
            array = newArray;
        array[0] = item;
        size++;
        return item;
    }
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E poppedItem = (E) array[0];
        for (int i = 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return poppedItem;
    }


    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return (E) array[0];
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        String result = "[" + array[0];
        for (int i = 1; i < size; i++) {
            result += ", " + array[i];
        }
        result += "]";
        return result;
    }

    @Override
    public int search(E item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return  i + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("blue");
        stack.push("yellow");
        stack.push("green");
        stack.push("orange");

        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Empty: " + stack.empty());
        System.out.println("Search: " + stack.search("yellow"));
        System.out.println("Search: " + stack.search("orange"));
    }
}
