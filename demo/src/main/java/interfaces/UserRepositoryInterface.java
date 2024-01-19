package interfaces;

import Dtos.SchoolSubjectGradeDto;

import java.util.List;

public interface UserRepositoryInterface {

    void createNewGrade(SchoolSubjectGradeDto newSubject);
    void editGrade(int i, String physiks);
    void deleteGrade(int i);
    List<SchoolSubjectGradeDto> findAll();
    List<SchoolSubjectGradeDto> findAllAvg();
    List<SchoolSubjectGradeDto> findById(int i);
}
