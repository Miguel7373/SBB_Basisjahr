package com.example.demo.interfaces;

import com.example.demo.Dtos.*;

import java.util.List;

public interface UserServiceInterface {
    void createNewGrade(SchoolSubjectGradeDto newSubject);
    void editGrade(int id, GradeDto gradeDto);
    void deleteGrade(int i);
    List<SubjectCountDto> findAll(int user_id);
    List<AvgGradeDto> findAllAvg(int user_id);
    List<SubjectDto> findById(int id);
    String getActiveProfiles();
}