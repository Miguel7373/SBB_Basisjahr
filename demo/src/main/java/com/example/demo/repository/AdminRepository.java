package com.example.demo.repository;

import com.example.demo.Dtos.SubjectDto;
import com.example.demo.interfaces.AdminRepositoryInterface;
import com.example.demo.rowmapper.SubjectDtoResultSetExtractor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AdminRepository implements AdminRepositoryInterface {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;


    public AdminRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
    public void editSubject(int subjectId, SubjectDto updatedSubject) {
        String sql = "UPDATE SUBJECT SET SUBJECT = ? WHERE ID_SUBJECT = ?;";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setString(1, updatedSubject.getName());
            preparedStatement.setInt(2, subjectId);
        };

        jdbcTemplate.update(sql, preparedStatementSetter);
    }
    @Override
    public List<SubjectDto> findAll() {
        String sql = "SELECT * FROM SUBJECT";
        return namedParameterJdbcTemplate.query(sql, new SubjectDtoResultSetExtractor());
    }
    @Override
    public void deleteSubject(int subjectId) {
        System.out.println(subjectId);
        String sql = "DELETE FROM SCHOOL_SUBJECT.SUBJECT WHERE ID_SUBJECT = ?;";
        PreparedStatementSetter preparedStatementSetter = preparedStatement -> {
            preparedStatement.setInt(1, subjectId);
        };
        jdbcTemplate.update(sql, preparedStatementSetter);
    }
}