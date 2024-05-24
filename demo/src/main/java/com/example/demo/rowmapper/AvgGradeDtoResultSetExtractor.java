package com.example.demo.rowmapper;

import com.example.demo.Dtos.AvgGradeDto;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvgGradeDtoResultSetExtractor implements ResultSetExtractor<List<AvgGradeDto>> {

    @Override
    public List<AvgGradeDto> extractData(ResultSet resultSet) throws SQLException {
        List<AvgGradeDto> avgGradeDtos = new ArrayList<>();

        while (resultSet.next()) {
            double avgGrade = resultSet.getDouble("average_grade");
            String subjectName = resultSet.getString("SUBJECT");
            int subjectId = resultSet.getInt("ID_SUBJECT");

            AvgGradeDto avgGradeDto = new AvgGradeDto(subjectName, avgGrade,subjectId);
            avgGradeDtos.add(avgGradeDto);
        }
        return avgGradeDtos;
    }
}
