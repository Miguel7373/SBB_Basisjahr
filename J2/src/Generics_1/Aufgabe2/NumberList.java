package Generics_1.Aufgabe2;
import java.util.List;
public class NumberList<T extends Number> {
    private List<T> numbers;
    public NumberList(List<T> numbers) {
        this.numbers = numbers;
    }
    public T largest() {

        T largest = numbers.get(0);
        for (T number : numbers) {
            if (number.doubleValue() > largest.doubleValue()) {
                largest = number;
            }
        }
        return largest;
    }
    public T smallest() {
        T smallest = numbers.get(0);
        for (T number : numbers) {
            if (number.doubleValue() < smallest.doubleValue()) {
                smallest = number;
            }
        }
        return smallest;
    }
    public static void main(String[] args) {
        List<Number> numberList = List.of(6, 1.1, 3.8, 5);
        NumberList<Number> numberNumberList = new NumberList<>(numberList);
        System.out.println("Größte Zahl: " + numberNumberList.largest());
        System.out.println("Kleinste Zahl: " + numberNumberList.smallest());
    }
}