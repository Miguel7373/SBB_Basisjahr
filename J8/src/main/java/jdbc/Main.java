package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Connection connection;

    public static void main(String[] args) {
        boolean mainLoop = true;
        while (mainLoop) {
            System.out.println("""
                    1: Füge eine Note hinzu
                    2: Lösche eine Note
                    3: Update eine Note
                    4: Deine Noten In einem Fach
                    5: Durchschnitt aller Fächer
                    Exit
                    """);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    openDataBaseConnection();

                    System.out.println("Existing Data:");

                    PrintTable.printTableDataSUBJECT();
                    System.out.print("Enter Subject ID: ");
                    int subjectId = scanner.nextInt();
                    scanner.nextLine();

                    PrintTable.printTableDataGRADE();
                    System.out.print("Enter Grade ID: ");
                    int gradeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the Date (Format: DAY-MONTH-YEAR): ");
                    String dateString = scanner.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                    try {
                        Date date = dateFormat.parse(dateString);
                        Ausführung.createData(date, gradeId, subjectId);
                        System.out.println("Grade added successfully!");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } finally {
                        closeDataBaseConnection();
                    }
                }
                case "2" -> {
                    openDataBaseConnection();

                    System.out.println("Existing Data:");
                    PrintTable.printTableDataSubject();

                    System.out.print("Enter ID to delete: ");
                    int subjectIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        Ausführung.deleteData(subjectIdToDelete);
                    } finally {
                        closeDataBaseConnection();
                    }
                }
                case "3" -> {
                    openDataBaseConnection();


                    System.out.println("Existing Data:");
                    PrintTable.printTableDataSubject();

                    System.out.print("Enter ID of the subject to update: ");
                    int IdToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    PrintTable.printTableDataSUBJECT();
                    System.out.print("Enter the New Subject ID: ");
                    int newSubjectId = scanner.nextInt();
                    scanner.nextLine();

                    PrintTable.printTableDataGRADE();
                    System.out.print("Enter the New Grade ID: ");
                    int newGradeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter the New Date (Format: DAY-MONTH-YEAR): ");
                    String newDateString = scanner.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        Date newDate = dateFormat.parse(newDateString);
                        Ausführung.updateData(IdToUpdate, newDate, newGradeId, newSubjectId);
                        System.out.println("Grade updated successfully!");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    } finally {
                        closeDataBaseConnection();
                    }
                }
                case "4" -> {
                    openDataBaseConnection();

                    System.out.println("Existing Subjects:");
                    PrintTable.printTableDataSUBJECT();

                    System.out.print("Enter Subject ID to view grades: ");
                    int subjectIdToView = scanner.nextInt();
                    scanner.nextLine();

                    PrintTable.printGradesAndAverageForSubject(subjectIdToView);


                    closeDataBaseConnection();
                }
                case "5" -> {
                    openDataBaseConnection();
                    System.out.println("Average Grades for all Subjects (Zeugnis):");
                    PrintTable.printAverageGradesForAllSubjects();
                    closeDataBaseConnection();
                }
                case "exit"  -> {
                    mainLoop = false;
                    break;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void openDataBaseConnection() {
        try {
            System.out.println("Connecting To Database...");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCHOOL_SUBJECT", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeDataBaseConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("\nConnection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}