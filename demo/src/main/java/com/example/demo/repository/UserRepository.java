package com.example.demo.repository;

import com.example.demo.Dtos.SchoolSubjectGradeDto;
import com.example.demo.interfaces.UserRepositoryInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private final JdbcTemplate jdbcTemplate;


    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void createNewGrade(SchoolSubjectGradeDto newGrade) {
        String sql = "INSERT INTO SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE (id_grade, id_subject, date) VALUES (?, ?, ?)";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, newGrade.getGrade_id());
            preparedStatement.setInt(2, newGrade.getSubject_id());
            preparedStatement.setString(3, newGrade.getDate());
        };

        jdbcTemplate.update(sql, preparedStatementSetter);
    }
    @Override
    public void editGrade(int i, String physiks) {
        String sql = "UPDATE SCHOOL_SUBJECT.SCHOOL_SUBJECT_GRADE SET date = ?, id_grade = ?, id_subject = ? WHERE ID = ?";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
//            preparedStatement.setDate(1, newDate.getTime);
//            preparedStatement.setInt(2, newGradeId);
//            preparedStatement.setInt(3, newSubjectId);
//            preparedStatement.setInt(4, id);
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }
    @Override
    public void deleteGrade(int i) {
    }
    @Override
    public List<SchoolSubjectGradeDto> findAll() {
        return null;
    }
    @Override
    public List<SchoolSubjectGradeDto> findAllAvg() {
        return null;
    }
    @Override
    public List<SchoolSubjectGradeDto> findById(int i) {
        return null;
    }
}
