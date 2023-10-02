package Bibliothek;

public class LibraryItem<T> {
        private String title;
        private boolean isCheckedOut;
        private T itemDetails;

        public LibraryItem(String title, T itemDetails) {
            this.title = title;
            this.isCheckedOut = false;
            this.itemDetails = itemDetails;
        }

        public String getTitle() {
            return title;
        }

        public boolean isCheckedOut() {
            return isCheckedOut;
        }

        public void checkOut() {
            isCheckedOut = true;
        }

        public void returnItem() {
            isCheckedOut = false;
        }

        public T getItemDetails() {
            return itemDetails;
        }
    }

