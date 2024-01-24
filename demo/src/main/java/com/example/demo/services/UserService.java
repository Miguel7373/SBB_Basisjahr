package com.example.demo.services;

import com.example.demo.Dtos.SchoolSubjectGradeDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createNewGrade(SchoolSubjectGradeDto newGrade) {
        userRepository.createNewGrade(newGrade);
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
