package labs_J1;

public class aufgabe2 {


    public static String Name(String name) {

        if (name.contains("Miguel")) {
            name = "Hallo Miguel";
        }
        return name;
    }


    public static String isLeapYear() {
        int year = 400;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return "Das ist ein Schalt jahr";
                } else {
                    return "Das ist kein Schalt jahr";
                }
            } else {
                return "Das ist ein Schalt jahr";
            }
        } else {
            return "Das ist kein Schalt jahr";
        }
    }

    public static String checkEvenOdd(int number) {
        if (number % 2 == 0) {
            return "Die Zahl ist gerade.";
        } else {
            return "Die Zahl ist ungerade.";
        }
    }



    public static String checkNumber(int number) {
        if (number > 0) {
            return "Die Zahl ist größer als 0.";
        } else if (number < 0) {
            return "Die Zahl ist kleiner als 0.";
        } else {
            return "Die Zahl ist gleich 0.";
        }
    }


  public static void main(String[] args) {
      System.out.println(Name("Hallo miguel"));
      System.out.println(checkNumber(3));
      System.out.println(isLeapYear());
      System.out.println(checkEvenOdd(3));
  }
}