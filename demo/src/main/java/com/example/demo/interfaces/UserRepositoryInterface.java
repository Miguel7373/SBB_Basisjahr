package com.example.demo.interfaces;
import com.example.demo.Dtos.AvgGradeDto;
import com.example.demo.Dtos.GradeDateDto;
import com.example.demo.Dtos.SchoolSubjectGradeDto;
import com.example.demo.Dtos.SchoolSubjectGradeOutDto;

import java.util.List;

public interface UserRepositoryInterface {

    void createNewGrade(SchoolSubjectGradeDto newSubject);
    void editGrade(int i, SchoolSubjectGradeDto newSubject);
    void deleteGrade(int i);
    List<GradeDateDto> findAll(int id);
    List<AvgGradeDto> findAllAvg();
    String getActiveProfiles();
}