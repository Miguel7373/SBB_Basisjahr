package Services;

import Dtos.SchoolSubjectGradeDto;
import Repository.UserRepository;
import interfaces.UserServiceInterface;

import java.util.List;

public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createNewGrade(SchoolSubjectGradeDto newSubject) {
        userRepository.createNewGrade(newSubject);
    }
    @Override
    public void editGrade(int id, String physiks) {
        userRepository.editGrade(2,"Physiks");

    }
    @Override
    public void deleteGrade(int i) {
        userRepository.deleteGrade(1);

    }
    @Override
    public List<SchoolSubjectGradeDto> findAll() {
        return userRepository.findAll();
    }
    @Override
    public List<SchoolSubjectGradeDto> findAllAvg() {
        return  userRepository.findAllAvg();
    }
    @Override
    public List<SchoolSubjectGradeDto> findById(int id) {
        return userRepository.findById(1);
    }
}
