package Bibliothek;
public class LibraryItem<T extends Media> {
    private String title;
    private T item;
    private boolean checkedOut = false;
    public LibraryItem(String title, T item) {
        this.title = title;
        this.item = item;
    }
    public String getTitle() {
        return title;
    }
    public T getItem() {
        return item;
    }
    public boolean isCheckedOut() {
        return checkedOut;
    }
    public void checkOut() {
        checkedOut = true;
    }
    public void returnItem() {
        checkedOut = false;
    }
}