package com.example.demo.interfaces;
import com.example.demo.Dtos.*;

import java.util.List;

public interface UserRepositoryInterface {

    void createNewGrade(SchoolSubjectGradeDto newSubject);
    void editGrade(int id, GradeDto gradeDto);
    void deleteGrade(int i);
    List<GradeDateDto> findAll(int id, int user_id);
    List<AvgGradeDto> findAllAvg(int user_id);
    String getActiveProfiles();
}