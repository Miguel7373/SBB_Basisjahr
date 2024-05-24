package com.example.demo.rowmapper;

import com.example.demo.Dtos.GradeDateDto;
import com.example.demo.Dtos.SchoolSubjectGradeDto;
import com.example.demo.Dtos.SchoolSubjectGradeOutDto;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolSubjectGradeDtoResultSetExtractor implements ResultSetExtractor<List<SchoolSubjectGradeOutDto>> {
    @Override
    public List<SchoolSubjectGradeOutDto> extractData(ResultSet resultSet) throws SQLException {
        List<SchoolSubjectGradeOutDto> schoolSubjectDtos = new ArrayList<>();

        while (resultSet.next()) {
            String subjectId = resultSet.getString("s.SUBJECT");
            List<GradeDateDto> grades = new ArrayList<>();
            do {
                Double grade = resultSet.getDouble("g.GRADE");
                String date = resultSet.getString("gs.DATE");
                GradeDateDto gradeDateDto = new GradeDateDto(date, grade);
                grades.add(gradeDateDto);
            }while (resultSet.next());

            SchoolSubjectGradeOutDto schoolSubjectGradeOutDto = new SchoolSubjectGradeOutDto(subjectId,grades);
            schoolSubjectDtos.add(schoolSubjectGradeOutDto);
        }

        return schoolSubjectDtos;
    }
}