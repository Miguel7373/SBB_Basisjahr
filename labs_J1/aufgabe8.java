package labs_J1;
import java.util.Arrays;
import java.util.Scanner;
public class aufgabe8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zahlen Kombination");
        String[] num = scanner.nextLine().split("");
        System.out.println("Single Number");
        int sn = scanner.nextInt();
        Arrays.sort(num);
        int key = sn;
        int res = Arrays.binarySearch(num, String.valueOf(key));
        if (res >= 0)
            System.out.println(key + " found at index = " + res);
        else
            System.out.println(key + " Not found");
        int lafadf = Integer.parseInt(num[num.length -1 ]);
        System.out.println(lafadf);
    }
}

