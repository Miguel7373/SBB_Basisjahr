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
        List<AvgGradeDto> schoolSubjectDtos = new ArrayList<>();

        while (resultSet.next()) {
            double avgGrade = resultSet.getDouble("AVG(g.GRADE)");
            String subjectName = resultSet.getString("s.SUBJECT");

            AvgGradeDto schoolSubjectDto = new AvgGradeDto(subjectName,avgGrade);
            schoolSubjectDtos.add(schoolSubjectDto);
        }
        return schoolSubjectDtos;
    }
}
