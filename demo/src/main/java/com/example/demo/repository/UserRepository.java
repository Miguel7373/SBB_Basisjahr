package com.example.demo.repository;

import com.example.demo.Dtos.AvgGradeDto;
import com.example.demo.Dtos.Dto;
import com.example.demo.Dtos.SchoolSubjectGradeDto;
import com.example.demo.Dtos.SchoolSubjectGradeOutDto;
import com.example.demo.interfaces.UserRepositoryInterface;
import com.example.demo.rowmapper.AvgGradeDtoResultSetExtractor;
import com.example.demo.rowmapper.SchoolSubjectGradeDtoResultSetExtractor;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
        String sql = "INSERT INTO SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE (grade_id, subject_id, date) VALUES (?, ?, ?)";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, newGrade.getGrade_id());
            preparedStatement.setInt(2, newGrade.getSubject_id());
            preparedStatement.setString(3, newGrade.getDate());
        };

        jdbcTemplate.update(sql, preparedStatementSetter);
    }
    @Override
    public void editGrade(int id, SchoolSubjectGradeDto newGrade) {
        String sql = "UPDATE SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE SET date = ?, grade_id = ?, subject_id = ? WHERE ID = ?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, newGrade.getDate());
            preparedStatement.setInt(2, newGrade.getGrade_id());
            preparedStatement.setInt(3, newGrade.getSubject_id());
            preparedStatement.setInt(4, id);
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }
    @Override
    public void deleteGrade(int id) {
        String sql = "DELETE FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public List<SchoolSubjectGradeOutDto> findAll() {
        String sql = "SELECT g.GRADE, s.SUBJECT " +
                "FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE " +
                "JOIN SCHOOL_SUBJECT.GRADE g on SCHOOL_SUBJECT_GRADE.grade_id = g.ID_GRADE " +
                "JOIN SCHOOL_SUBJECT.SUBJECT s on SCHOOL_SUBJECT_GRADE.subject_id = s.ID_SUBJECT " +
                "GROUP BY subject_id";
        return jdbcTemplate.query(sql, new SchoolSubjectGradeDtoResultSetExtractor());
    }
    @Override
    public List<AvgGradeDto> findAllAvg() {
        String sql = "SELECT AVG(g.GRADE), s.SUBJECT " +
                "FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE " +
                "JOIN SCHOOL_SUBJECT.GRADE g on SCHOOL_SUBJECT_GRADE.grade_id = g.ID_GRADE " +
                "JOIN SCHOOL_SUBJECT.SUBJECT s on SCHOOL_SUBJECT_GRADE.subject_id = s.ID_SUBJECT " +
                "GROUP BY subject_id";

        return jdbcTemplate.query(sql, new AvgGradeDtoResultSetExtractor());
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

        return jdbcTemplate.query(sql,preparedStatementSetter, new AvgGradeDtoResultSetExtractor());
    }
    public List<SchoolSubjectGradeOutDto> findAllID(int id) {
        String sql = "SELECT g.GRADE, s.SUBJECT " +
                "FROM SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE " +
                "JOIN SCHOOL_SUBJECT.GRADE g on SCHOOL_SUBJECT_GRADE.grade_id = g.ID_GRADE " +
                "JOIN SCHOOL_SUBJECT.SUBJECT s on SCHOOL_SUBJECT_GRADE.subject_id = s.ID_SUBJECT " +
                "WHERE s.ID_SUBJECT = ?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, id);
        };

        return jdbcTemplate.query(sql,preparedStatementSetter, new SchoolSubjectGradeDtoResultSetExtractor());
    }
    public String getActiveProfiles() {
        return Arrays.toString(environment.getActiveProfiles());
    }

}
