package Generics_1.Aufgabe1;


import java.util.List;

public class main {
    public static void printArray(Object[] array) {
        for (Object element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Object[] mixedArray = {1, "Hallo", 2.5, "Welt", 3};

        System.out.println("Gemischtes Array:");
        printArray(mixedArray);
    }
}