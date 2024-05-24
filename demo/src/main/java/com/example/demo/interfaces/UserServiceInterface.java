package com.example.demo.interfaces;

import com.example.demo.Dtos.AvgGradeDto;

import com.example.demo.Dtos.SchoolSubjectGradeDto;
import com.example.demo.Dtos.SchoolSubjectGradeOutDto;
import com.example.demo.Dtos.SubjectDto;

import java.util.List;

public interface UserServiceInterface {
    void createNewGrade(SchoolSubjectGradeDto newSubject);
    void editGrade(int id, SchoolSubjectGradeDto newSubject);
    void deleteGrade(int i);
    List<SubjectDto> findAll();
    List<AvgGradeDto> findAllAvg();
    List<SubjectDto> findById(int id);
    String getActiveProfiles();
}