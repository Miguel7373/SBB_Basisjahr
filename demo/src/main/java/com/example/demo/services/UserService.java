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
    public void editGrade(int id, GradeDto gradeDto) {
        userRepository.editGrade(id, gradeDto);

    }
    @Override
    public void deleteGrade(int id) {
        userRepository.deleteGrade(id);

    }
    @Override
    public List<SubjectCountDto> findAll(int user_id) {

        List<SubjectCountDto> combinedList = new ArrayList<>();
        List<SubjectCountDto> allSubjects = userRepository.getAllSubjects();

        allSubjects.forEach(s -> {
            List<GradeDateDto> allGrades = userRepository.findAll(s.getSubject_id(),user_id);
            newOutDto newDto = new newOutDto(s.getName(), s.getSubject_id(), allGrades);
            combinedList.add(newDto);
//            newDto.getGrade().stream().forEach(System.out::println);
        });
        return combinedList;
    }
    @Override
    public List<AvgGradeDto> findAllAvg(int user_id) {
        return  userRepository.findAllAvg(user_id);
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