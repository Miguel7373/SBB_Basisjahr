package com.example.demo.services;

import com.example.demo.Dtos.*;

import com.example.demo.repository.UserRepository;
import com.example.demo.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

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
    public List<SubjectDto> findAll() {
        List<SubjectDto> combinedList = new ArrayList<>();
        List<SubjectCountDto> timoiscoocking = userRepository.getAllSubjects();

        timoiscoocking.forEach(s -> {
            List<GradeDateDto> allGrades = userRepository.findAll(s.getSubject_id());
            SchoolSubjectGradeOutDto newDto = new SchoolSubjectGradeOutDto(s.getName(), allGrades);
            combinedList.add(newDto);
//            newDto.getGrade().stream().forEach(System.out::println);
        });
        return combinedList;
    }
    @Override
    public List<AvgGradeDto> findAllAvg() {
        return  userRepository.findAllAvg();
    }
    @Override
    public List<SubjectDto> findById(int id) {
        List<AvgGradeDto> avgGrades = userRepository.findAllAvgId(id);
        List<SchoolSubjectGradeOutDto> schoolSubjectGrades = userRepository.findAllID(id);

        List<SubjectDto> combinedList = new ArrayList<>();
        combinedList.addAll(avgGrades);
        combinedList.addAll(schoolSubjectGrades);

        return combinedList;
    }
    public String getActiveProfiles(){
        return userRepository.getActiveProfiles();
    }
}