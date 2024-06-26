package com.example.demo.repository;

import com.example.demo.Dtos.*;
import com.example.demo.interfaces.UserRepositoryInterface;
import com.example.demo.rowmapper.AvgGradeDtoResultSetExtractor;
import com.example.demo.rowmapper.GradeDtoResultSetExtractor;
import com.example.demo.rowmapper.SchoolSubjectGradeDtoResultSetExtractor;
import com.example.demo.rowmapper.SubjectCountDtoResultSetExtractor;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private final JdbcTemplate jdbcTemplate;

    private final Environment environment;

    public UserRepository(JdbcTemplate jdbcTemplate, Environment environment) {
        this.jdbcTemplate = jdbcTemplate;
        this.environment = environment;
    }

    public void createNewGrade(SchoolSubjectGradeDto newGrade) {
        String sql = "INSERT INTO SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE (grade_id, subject_id, date, user_id) VALUES (?, ?, ?, ?)";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, newGrade.getGrade_id());
            preparedStatement.setInt(2, newGrade.getSubject_id());
            preparedStatement.setString(3, newGrade.getDate());
            preparedStatement.setInt(4, newGrade.getUser_id());
        };

        jdbcTemplate.update(sql, preparedStatementSetter);
    }


    @Override
    public void editGrade(int id, GradeDto gradeDto) {
        String sql = "UPDATE SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE SET grade_id = ? WHERE ID = ?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, gradeDto.getGrade_Id());
            preparedStatement.setInt(2, id);
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }

    @Override
    public void deleteGrade(int id) {
        String sql = "DELETE FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<GradeDateDto> findAll(int id, int user_id) {
        String sql = "SELECT gs.ID, g.GRADE, gs.DATE " +
                "FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE gs " +
                "JOIN SCHOOL_SUBJECT.GRADE g on gs.grade_id = g.ID_GRADE " +
                "where subject_id = ? AND user_id = ?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, user_id);
        };
        return jdbcTemplate.query(sql, preparedStatementSetter, new GradeDtoResultSetExtractor());
    }

    @Override
    public List<AvgGradeDto> findAllAvg(int user_id) {
        String sql = """
                SELECT COALESCE(AVG(g.GRADE), 0) AS average_grade, s.SUBJECT , s.ID_SUBJECT
                FROM SCHOOL_SUBJECT.SUBJECT s
                LEFT JOIN SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE sg ON s.ID_SUBJECT = sg.subject_id
                LEFT JOIN SCHOOL_SUBJECT.GRADE g ON sg.grade_id = g.ID_GRADE AND sg.user_id = ?
                
                GROUP BY s.SUBJECT;
                """;

        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, user_id);
        };
        return jdbcTemplate.query(sql,preparedStatementSetter, new AvgGradeDtoResultSetExtractor());
    }


    public List<AvgGradeDto> findAllAvgId(int id) {
        String sql = "SELECT AVG(g.GRADE), s.SUBJECT " +
                "FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE " +
                "JOIN SCHOOL_SUBJECT.GRADE g on SCHOOL_SUBJECT_GRADE.grade_id = g.ID_GRADE " +
                "JOIN SCHOOL_SUBJECT.SUBJECT s on SCHOOL_SUBJECT_GRADE.subject_id = s.ID_SUBJECT " +
                "WHERE s.ID_SUBJECT = ?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, id);
        };

        return jdbcTemplate.query(sql, preparedStatementSetter, new AvgGradeDtoResultSetExtractor());
    }

    public List<SchoolSubjectGradeOutDto> findAllID(int id) {
        String sql = "SELECT gs.ID, g.GRADE, s.SUBJECT, gs.subject_id, gs.DATE " +
                "FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE gs " +
                "JOIN SCHOOL_SUBJECT.GRADE g on gs.grade_id = g.ID_GRADE " +
                "JOIN SCHOOL_SUBJECT.SUBJECT s on gs.subject_id = s.ID_SUBJECT " +
                "WHERE s.ID_SUBJECT = ?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, id);
        };

        return jdbcTemplate.query(sql, preparedStatementSetter, new SchoolSubjectGradeDtoResultSetExtractor());
    }

    public String getActiveProfiles() {
        return Arrays.toString(environment.getActiveProfiles());
    }

    public List<SubjectCountDto> getAllSubjects() {
        String sql = "SELECT DISTINCT s.SUBJECT, subject_id " +
                "FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE " +
                "JOIN SCHOOL_SUBJECT.SUBJECT s on SCHOOL_SUBJECT_GRADE.subject_id = s.ID_SUBJECT ";
        return jdbcTemplate.query(sql, new SubjectCountDtoResultSetExtractor());

    }
}