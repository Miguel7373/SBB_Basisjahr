package Generics_1.Aufgabe2;
import java.util.ArrayList;
import java.util.List;

public class NumberList<T extends Number> {
    List<T> myList = new ArrayList<T>();

    public List<T> getMyList() {
        return myList;


        NumberList<Double> integerList = new NumberList<>();
        integerList.getMyList().add(1.1);
        integerList.getMyList().add(1.2);
        integerList.getMyList().add(1.3);
        System.out.println(myList);
    }



     public static void main(String[] args) {


    }
}