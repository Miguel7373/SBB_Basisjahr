package com.example.demo.rowmapper;

import com.example.demo.Dtos.SchoolSubjectGradeOutDto;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDtoResultSetExtractor implements ResultSetExtractor<List<Double>>{
    @Override
    public List<Double> extractData(ResultSet resultSet) throws SQLException {
        List<Double> grades = new ArrayList<>();

        while (resultSet.next()) {
                grades.add(resultSet.getDouble("g.GRADE"));
        }

        return grades;
    }
}