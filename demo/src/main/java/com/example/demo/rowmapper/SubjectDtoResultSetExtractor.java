package com.example.demo.rowmapper;

import com.example.demo.Dtos.SubjectDto;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDtoResultSetExtractor implements ResultSetExtractor<List<SubjectDto>> {
    @Override
    public List<SubjectDto> extractData(ResultSet resultSet) throws SQLException {
        List<SubjectDto> schoolSubjectDtos = new ArrayList<>();

        while (resultSet.next()) {
            String subjectName = resultSet.getString("subject_name");

            SubjectDto schoolSubjectDto = new SubjectDto(subjectName);
            schoolSubjectDtos.add(schoolSubjectDto);
        }

        return schoolSubjectDtos;
    }
}
