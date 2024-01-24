package com.example.demo.rowmapper;

import com.example.demo.Dtos.SchoolSubjectGradeDto;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolSubjectGradeDtoResultSetExtractor implements ResultSetExtractor<List<SchoolSubjectGradeDto>> {
    @Override
    public List<SchoolSubjectGradeDto> extractData(ResultSet resultSet) throws SQLException {
        List<SchoolSubjectGradeDto> schoolSubjectDtos = new ArrayList<>();

        while (resultSet.next()) {
            int subjectId = resultSet.getInt("subject_id");
            int gradeId = resultSet.getInt("grade_id");
            String date = resultSet.getString("date");

            SchoolSubjectGradeDto schoolSubjectDto = new SchoolSubjectGradeDto(subjectId,gradeId,date);
            schoolSubjectDtos.add(schoolSubjectDto);
        }

        return schoolSubjectDtos;
    }
}