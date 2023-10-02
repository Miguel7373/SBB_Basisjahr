package Bibliothek;
import java.util.ArrayList;
import java.util.List;
public class Library<T> {
    private List<LibraryItem<T>> inventory = new ArrayList<>();
    public void addItem(String title, T itemDetails) {
        LibraryItem<T> newItem = new LibraryItem<>(title, itemDetails);
        inventory.add(newItem);
    }
    public boolean checkOutItem(String title) {
        for (LibraryItem<T> item : inventory) {
            if (item.getTitle().equals(title) && !item.isCheckedOut()) {
                item.checkOut();
                return true;
            }
        }
        return false;
    }
    public void returnItem(String title) {
        for (LibraryItem<T> item : inventory) {
            if (item.getTitle().equals(title)) {
                item.returnItem();
                break;
            }
        }
    }
    public void listInventory() {
        System.out.println("Inventar der Bibliothek:");
        for (LibraryItem<T> item : inventory) {
            String status = item.isCheckedOut() ? "Ausgeliehen" : "Verfügbar";
            System.out.println("Titel: " + item.getTitle() + " (" + status + ")");
            System.out.println("Details: " + item.getItemDetails());
            System.out.println();
        }
    }
}