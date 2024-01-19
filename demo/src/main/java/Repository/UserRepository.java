package Repository;

import Dtos.SchoolSubjectGradeDto;
import interfaces.UserRepositoryInterface;

import java.util.List;

public class UserRepository implements UserRepositoryInterface {
    public void createNewGrade(SchoolSubjectGradeDto newSubject) {

    }
    @Override
    public void editGrade(int i, String physiks) {
    }
    @Override
    public void deleteGrade(int i) {
    }
    @Override
    public List<SchoolSubjectGradeDto> findAll() {
        return null;
    }
    @Override
    public List<SchoolSubjectGradeDto> findAllAvg() {
        return null;
    }
    @Override
    public List<SchoolSubjectGradeDto> findById(int i) {
        return null;
    }
}
