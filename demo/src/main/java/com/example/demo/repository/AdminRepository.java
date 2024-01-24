package com.example.demo.repository;

import com.example.demo.Dtos.SubjectDto;
import com.example.demo.interfaces.AdminRepositoryInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AdminRepository implements AdminRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;


    public AdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createNewSubject(SubjectDto newSubject) {
        String sql = "INSERT INTO SUBJECT (SUBJECT) VALUES (?)";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, newSubject.getName());
        };

        jdbcTemplate.update(sql, preparedStatementSetter);
    }
    @Override
    public void editSubject(int subjectId) {

    }
    @Override
    public List<SubjectDto> findAll() {
        return null;
    }
    @Override
    public void deleteSubject(int subjectId) {
        String sql = "DELETE FROM SUBJECT WHERE ID_SUBJECT = ?";
        jdbcTemplate.update(sql, subjectId);
    }
}
