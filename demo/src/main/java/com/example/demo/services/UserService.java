package com.example.demo.services;

import com.example.demo.Dtos.AvgGradeDto;
import com.example.demo.Dtos.Dto;
import com.example.demo.Dtos.SchoolSubjectGradeDto;
import com.example.demo.Dtos.SchoolSubjectGradeOutDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void editGrade(int id, SchoolSubjectGradeDto newGrade) {
        userRepository.editGrade(id, newGrade);

    }
    @Override
    public void deleteGrade(int id) {
        userRepository.deleteGrade(id);

    }
    @Override
    public List<SchoolSubjectGradeOutDto> findAll() {
        return userRepository.findAll();
    }
    @Override
    public List<AvgGradeDto> findAllAvg() {
        return  userRepository.findAllAvg();
    }
    @Override
    public List<Dto> findById(int id) {
        List<AvgGradeDto> avgGrades = userRepository.findAllAvgId(id);
        List<SchoolSubjectGradeOutDto> schoolSubjectGrades = userRepository.findAllID(id);

        List<Dto> combinedList = new ArrayList<>();
        combinedList.addAll(avgGrades);
        combinedList.addAll(schoolSubjectGrades);

        return combinedList;
    }
    public String getActiveProfiles(){
        return userRepository.getActiveProfiles();
    }
}
