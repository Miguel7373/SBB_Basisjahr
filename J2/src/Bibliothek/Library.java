package Bibliothek;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends Media> {
    private List<LibraryItem<T>> inventory = new ArrayList<>();
    private List<LibraryItem<T>> checkedOutItems = new ArrayList<>();
    public void addItem(String title, T item) {
        inventory.add(new LibraryItem<>(title, item));
    }
    public void listInventory() {
        System.out.println("Inventar der Bibliothek:");
        for (LibraryItem<T> item : inventory) {
            String status = item.isCheckedOut() ? "Ausgeliehen" : "Verfügbar";
            System.out.println("Titel: " + item.getTitle() + " (" + status + ")");
            System.out.println("Details: " + item.getItem().getItemDetails());
            System.out.println();
        }
    }
    public LibraryItem<T> getItem(String title) {
        for (LibraryItem<T> item : inventory) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }
    public boolean checkOutItem(String title) {
        LibraryItem<T> item = getItem(title);
        if (item != null && !item.isCheckedOut()) {
            item.checkOut();
            checkedOutItems.add(item);
            return true;
        }
        return false;
    }
    public boolean returnItem(String title) {
        LibraryItem<T> item = getItem(title);
        if (item != null && item.isCheckedOut()) {
            item.returnItem();
            checkedOutItems.remove(item);
            return true;
        }
        return false;
    }
    public boolean isItemCheckedOut(String title) {
        for (LibraryItem<T> item : checkedOutItems) {
            if (item.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}