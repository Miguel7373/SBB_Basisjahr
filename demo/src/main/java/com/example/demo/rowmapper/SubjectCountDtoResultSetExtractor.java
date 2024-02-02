package com.example.demo.rowmapper;

import com.example.demo.Dtos.AvgGradeDto;
import com.example.demo.Dtos.SchoolSubjectGradeOutDto;
import com.example.demo.Dtos.SubjectCountDto;
import com.example.demo.Dtos.SubjectDto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectCountDtoResultSetExtractor implements ResultSetExtractor<List<SubjectCountDto>>{
    List<SubjectCountDto> subjectCountDtos = new ArrayList<>();


    @Override
    public List<SubjectCountDto> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        while (resultSet.next()) {
            String name = resultSet.getString("s.SUBJECT");
            int subject_id = resultSet.getInt("subject_id");

            SubjectCountDto subjectCountDto = new SubjectCountDto(name,subject_id);
            subjectCountDtos.add(subjectCountDto);
        }
        return subjectCountDtos;
    }
}

