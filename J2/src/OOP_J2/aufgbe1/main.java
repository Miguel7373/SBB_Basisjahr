package OOP_J2.aufgbe1;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static String patientData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Checkup");
        System.out.println("Gib deine grösse ein");
        double dinputGrösse = scanner.nextDouble();

        System.out.println("Gib dein Gewicht ein");

        int dinputGewicht =  scanner.nextInt();
        System.out.println("Gib deine Temperatur ein");
        String  inputTempertatur = scanner.nextLine();
        double  dinputTemperatur = Double.parseDouble(inputTempertatur);
        System.out.println("Gib deinen Impfstatus ein (True/False)");
        String  inputImpft = scanner.nextLine();

        ArrayList<patient> patientList = new ArrayList<>();
        patient john = new patient("John");
        return (john.name +" Grösse "+ dinputGrösse +" Gewicht "+ dinputGewicht +" Temperature "+ dinputTemperatur +" Geimpft "+ inputImpft);
    }
    public static void main(String[] args) {
        System.out.println(patientData());


    }
}
