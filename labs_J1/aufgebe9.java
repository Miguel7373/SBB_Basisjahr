package labs_J1;
public class aufgebe9 {
    public static String Name(String name){
        name = "miguel";
        return name;
    }
    public static int summe(int zahl1, int zahl2){
        int result = zahl1 + zahl2;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(summe(1,2));
        System.out.println("Hallo " + Name(" "));
    }
}