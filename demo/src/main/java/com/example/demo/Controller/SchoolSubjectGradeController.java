package com.example.demo.Controller;
import com.example.demo.Dtos.AvgGradeDto;
import com.example.demo.Dtos.Dto;
import com.example.demo.Dtos.SchoolSubjectGradeOutDto;
import com.example.demo.services.UserService;
import com.example.demo.Dtos.SchoolSubjectGradeDto;
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
    public void createNewGrade(@RequestBody SchoolSubjectGradeDto newSubject) {
         userService.createNewGrade(newSubject);
    }
    @PutMapping("/school_subject_grade/grade/{id}")
    public void editGrade(@PathVariable int id ,SchoolSubjectGradeDto newGrade){
         userService.editGrade(id,newGrade);
    }
    @DeleteMapping("/school_subject_grade/grade/{id}")
    public void deleteGrade(@PathVariable int id){
         userService.deleteGrade(id);
    }

    @GetMapping("/school_subject_grade")
    public List<SchoolSubjectGradeOutDto> findAll() {
        return userService.findAll();
    }
    @GetMapping("/school_subject_grade/average")
    public List<AvgGradeDto> findAllAvg() {
        return userService.findAllAvg();
    }
    @GetMapping("/school_subject_grade/average/{id}")
    public List<Dto> findById(@PathVariable int id) {
        return userService.findById(id);
    }
    @GetMapping("/getActiveProfiles")
    public String getActiveProfiles(){
        return userService.getActiveProfiles();
    }
}
