package Generics_1.Aufgabe1;
public class main {
    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"apple", "banana", "cherry"};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};

        System.out.println("Integer Array:");
        printArray(intArray);
        System.out.println("String Array:");
        printArray(stringArray);
        System.out.println("Double Array:");
        printArray(doubleArray);
    }
}