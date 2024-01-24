package com.example.demo.Controller;
import com.example.demo.services.UserService;

import com.example.demo.Dtos.SchoolSubjectGradeDto;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/student")

public class SchoolSubjectGradeController {
    private final UserService userService;

    public SchoolSubjectGradeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createNewGrade")
    public void createNewGrade(@RequestBody SchoolSubjectGradeDto newSubject) {
         userService.createNewGrade(newSubject);
    }
    @PutMapping("/editGrade/{id}")
    public void editGrade(@PathVariable int id , String name){
         userService.editGrade(2,"Physiks");
    }
    @DeleteMapping("/deleteGrade/{id}")
    public void deleteGrade(@PathVariable int id){
         userService.deleteGrade(1);
    }

    @GetMapping("/findAll")
    public List<SchoolSubjectGradeDto> findAll() {
        return userService.findAll();
    }
    @GetMapping("/findAllAvg")
    public List<SchoolSubjectGradeDto> findAllAvg() {
        return userService.findAllAvg();
    }
    @GetMapping("/findById/{id}")
    public List<SchoolSubjectGradeDto> findById(@PathVariable int id) {
        return userService.findById(id);
    }
}
