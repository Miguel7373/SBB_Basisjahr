package com.example.demo.Controller;

import com.example.demo.Dtos.*;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class SchoolSubjectGradeController {
    private final UserService userService;

    public SchoolSubjectGradeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/school_subject_grade/grade")
    public void createNewGrade(@RequestBody SchoolSubjectGradeDto newGrade) {
        userService.createNewGrade(newGrade);
    }

    @PutMapping("/school_subject_grade/grade/{id}")
    public void editGrade(@PathVariable int id, @RequestBody GradeDto gradeDto) {
        userService.editGrade(id, gradeDto);
    }

    @DeleteMapping("/school_subject_grade/grade/{id}")
    public void deleteGrade(@PathVariable int id) {
        userService.deleteGrade(id);
    }

    @GetMapping("/school_subject_grade/{id}")
    public List<SubjectCountDto> findAll(@PathVariable String id) {
        return userService.findAll(Integer.parseInt(id));
    }

    @GetMapping("/school_subject_grade/averages/{id}")
    public List<AvgGradeDto> findAllAvg(@PathVariable int id) {
        return userService.findAllAvg(id);
    }

    @GetMapping("/school_subject_grade/average/{id}")
    public List<SubjectDto> findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @GetMapping("/Profiles")
    public String getActiveProfiles() {
        return userService.getActiveProfiles();
    }
}