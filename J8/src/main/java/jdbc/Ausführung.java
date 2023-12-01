package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static jdbc.Main.connection;

class Ausführung {
    static void createData(Date date, int gradeId, int subjectId) throws SQLException {

        try {
            String query = "INSERT INTO SCHOOL_SUBJECTANDGRADE(id_grade, id_subject, date) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, gradeId);
            preparedStatement.setInt(2, subjectId);
            preparedStatement.setDate(3, new java.sql.Date(date.getTime()));


            preparedStatement.executeUpdate();

            System.out.println("Grade added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void deleteData(int ID) {
        try {
            String query = "DELETE FROM SCHOOL_SUBJECTANDGRADE WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ID);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Subject deleted successfully!");
            } else {
                System.out.println("No subject found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void updateData(int id, Date newDate, int newGradeId, int newSubjectId) {
        try {
            String query = "UPDATE SCHOOL_SUBJECTANDGRADE SET date = ?, id_grade = ?, id_subject = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new java.sql.Date(newDate.getTime()));
            preparedStatement.setInt(2, newGradeId);
            preparedStatement.setInt(3, newSubjectId);
            preparedStatement.setInt(4, id);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Grade updated successfully!");
            } else {
                System.out.println("No subject found with the specified ID. Update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static double calculateAverageGrade(int subjectId) {
        try {
            String query = "SELECT AVG(GRADE.GRADE) FROM SCHOOL_SUBJECTANDGRADE " +
                    "INNER JOIN GRADE ON SCHOOL_SUBJECTANDGRADE.id_GRADE = GRADE.ID_GRADE " +
                    "WHERE SCHOOL_SUBJECTANDGRADE.id_SUBJECT = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }
}
