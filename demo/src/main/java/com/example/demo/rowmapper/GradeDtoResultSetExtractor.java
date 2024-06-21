package com.example.demo.rowmapper;

import com.example.demo.Dtos.GradeDateDto;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDtoResultSetExtractor implements ResultSetExtractor<List<GradeDateDto>>{
    @Override
    public List<GradeDateDto> extractData(ResultSet resultSet) throws SQLException {
        List<GradeDateDto> gradeDates = new ArrayList<>();

        while (resultSet.next()) {
            int gradeId = resultSet.getInt("gs.ID");
            String date = resultSet.getString("gs.DATE");
            Double grade = resultSet.getDouble("g.GRADE");

            GradeDateDto gradeDateDto = new GradeDateDto(gradeId, date, grade);

            gradeDates.add(gradeDateDto);
        }

        return gradeDates;
    }
}