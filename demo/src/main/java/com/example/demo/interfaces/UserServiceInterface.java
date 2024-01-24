package com.example.demo.interfaces;

import com.example.demo.Dtos.SchoolSubjectGradeDto;

import java.util.List;

public interface UserServiceInterface {
    void createNewGrade(SchoolSubjectGradeDto newSubject);
    void editGrade(int id, String physiks);
    void deleteGrade(int i);
    List<SchoolSubjectGradeDto> findAll();
    List<SchoolSubjectGradeDto> findAllAvg();
    List<SchoolSubjectGradeDto> findById(int id);
}
