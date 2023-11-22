package myStack;

public interface MyStackInterface<E> {
    public E push(E item);

    public E pop();
    public E peek();
    public int size();
    public boolean empty();
    public String toString();
    public int search(E item);
}
