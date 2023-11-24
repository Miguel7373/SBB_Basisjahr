package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PrintTable {
    static void printTableDataSUBJECT() {
        try {
            String query = "SELECT * FROM SUBJECT";
            PreparedStatement preparedStatement = Main.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Subject Table:");
            System.out.printf("%-15s %-15s%n", "ID_SUBJECT", "Subject");
            System.out.println("------------------------------");
            while (resultSet.next()) {
                int IDSubject = resultSet.getInt("ID_SUBJECT");
                String subject = resultSet.getString("SUBJECT");

                System.out.printf("%-15s %-15s%n", IDSubject, subject);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void printTableDataGRADE() {
        try {
            String query = "SELECT * FROM GRADE";
            PreparedStatement preparedStatement = Main.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Grade Table:");
            System.out.printf("%-15s %-15s%n", "ID_GRADE", "Grade");
            System.out.println("------------------------------");
            while (resultSet.next()) {
                int IDGRADE = resultSet.getInt("ID_GRADE");
                double grade = resultSet.getDouble("GRADE");

                System.out.printf("%-15s %-15s%n", IDGRADE, grade);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void printTableDataSubject() {
        try {
            String query = "SELECT s.ID ,g.GRADE, s.DATE, sub.SUBJECT FROM SCHOOL_SUBJECTANDGRADE s " +
                    "JOIN GRADE g ON s.ID_GRADE = g.ID_GRADE " +
                    "JOIN SUBJECT sub ON s.ID_SUBJECT = sub.ID_SUBJECT";

            try (PreparedStatement preparedStatement = Main.connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                System.out.println("Subject and Grade Table:");
                System.out.printf("%-10s %-15s %-20s %-15s%n", "ID", "Grade", "Subject Name", "Date");
                System.out.println("---------------------------------------------------");
                while (resultSet.next()) {
                    int ID = resultSet.getInt("ID");
                    double grade = resultSet.getDouble("GRADE");
                    String subjectName = resultSet.getString("SUBJECT");
                    Date date = resultSet.getDate("DATE");

                    System.out.printf("%-10s %-15s %-20s %-15s%n", ID, grade, subjectName, date);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printGradesAndAverageForSubject(int subjectId) {
        try {
            String query = "SELECT GRADE.GRADE, SCHOOL_SUBJECTANDGRADE.DATE " +
                    "FROM SCHOOL_SUBJECTANDGRADE " +
                    "INNER JOIN GRADE ON SCHOOL_SUBJECTANDGRADE.id_GRADE = GRADE.ID_GRADE " +
                    "WHERE SCHOOL_SUBJECTANDGRADE.id_SUBJECT = ?";
            PreparedStatement preparedStatement = Main.connection.prepareStatement(query);
            preparedStatement.setInt(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Grades for Subject " + subjectId + ":");
            System.out.printf("%-15s %-15s%n", "Grade", "Date");
            System.out.println("------------------------------");
            while (resultSet.next()) {
                double gradeValue = resultSet.getDouble("GRADE");
                Date date = resultSet.getDate("DATE");

                System.out.printf("%-15s %-15s%n", gradeValue, date);
            }

            double averageGrade = Ausführung.calculateAverageGrade(subjectId);
            System.out.println("Average Grade: " + averageGrade);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printAverageGradesForAllSubjects() {
        try {
            double totalAverage = 0.0;
            int subjectCount = 0;

            String query = "SELECT ID_SUBJECT, SUBJECT FROM SUBJECT";
            PreparedStatement preparedStatement = Main.connection.prepareStatement(query);
            ResultSet subjectResultSet = preparedStatement.executeQuery();

            while (subjectResultSet.next()) {
                int subjectId = subjectResultSet.getInt("ID_SUBJECT");
                String subjectName = subjectResultSet.getString("SUBJECT");

                String gradeQuery = "SELECT COUNT(*) FROM SCHOOL_SUBJECTANDGRADE " +
                        "WHERE id_SUBJECT = ?";
                PreparedStatement countStatement = Main.connection.prepareStatement(gradeQuery);
                countStatement.setInt(1, subjectId);
                ResultSet countResultSet = countStatement.executeQuery();
                countResultSet.next();
                int gradeCount = countResultSet.getInt(1);

                if (gradeCount > 0) {

                    String gradesQuery = "SELECT GRADE.GRADE FROM SCHOOL_SUBJECTANDGRADE " +
                            "INNER JOIN GRADE ON SCHOOL_SUBJECTANDGRADE.id_GRADE = GRADE.ID_GRADE " +
                            "WHERE SCHOOL_SUBJECTANDGRADE.id_SUBJECT = ?";
                    PreparedStatement gradesStatement = Main.connection.prepareStatement(gradesQuery);
                    gradesStatement.setInt(1, subjectId);
                    ResultSet gradeResultSet = gradesStatement.executeQuery();

                    System.out.println("Subject: " + subjectName + " (ID: " + subjectId + ")");
                    System.out.printf("%-15s%n", "Individual Grades:");
                    System.out.printf("%-15s%n", "------------------");
                    while (gradeResultSet.next()) {
                        double gradeValue = gradeResultSet.getDouble("GRADE");
                        System.out.printf("%-15s%n", "Grade: " + gradeValue);
                    }

                    double averageGrade = Ausführung.calculateAverageGrade(subjectId);
                    System.out.println("Average Grade: " + averageGrade);

                    totalAverage += averageGrade;
                    subjectCount++;

                    System.out.println();
                }
            }

            if (subjectCount > 0) {
                double overallAverage = totalAverage / subjectCount;
                System.out.println("Average of All Averages: " + overallAverage);
            } else {
                System.out.println("No subjects with grades found.");
            }

        } catch (SQLException e) {
            System.err.println("Error executing SQL query:");
            e.printStackTrace();
        }
    }
}