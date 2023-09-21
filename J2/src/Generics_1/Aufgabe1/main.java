package Generics_1.Aufgabe1;



public class main {
    public <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        String[] stringArray = { "Hallo", "Welt", "Generics" };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        main printer = new main();
        System.out.print("Integer Array: ");
        printer.printArray(intArray);

        System.out.print("String Array: ");
        printer.printArray(stringArray);

        System.out.print("Double Array: ");
        printer.printArray(doubleArray);
    }
}