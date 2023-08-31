package labs_J1;
public class aufgabe8 {
    public static int findePosition(int[] array, int zahl) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == zahl) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println();
        int[] array = {5, 10, 15, 20, 25};
        int zahl = 15;

        int position = findePosition(array, zahl);
        System.out.println(zahl + " Pos " + position);

        int groessteZahl = findeGroessteZahl(array);
        System.out.println("biggest number " + groessteZahl);

    }

    public static int findeGroessteZahl(int[] array) {
        int groessteZahl = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > groessteZahl) {
                groessteZahl = array[i];
            }
        }

        return groessteZahl;
    }
}

