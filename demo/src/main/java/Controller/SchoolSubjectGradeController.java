package Controller;
import Services.UserService;

import Dtos.SchoolSubjectGradeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/student/school_subject_grade")

public class SchoolSubjectGradeController {
    private final UserService userService;

    public SchoolSubjectGradeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/grade")
    public void createNewGrade(@RequestBody SchoolSubjectGradeDto newSubject) {
         userService.createNewGrade(newSubject);
    }
    @PutMapping("/{id}")
    public void editGrade(@PathVariable int id , String name){
         userService.editGrade(2,"Physiks");
    }
    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable int id){
         userService.deleteGrade(1);
    }

    @GetMapping
    public List<SchoolSubjectGradeDto> findAll() {
        return userService.findAll();
    }
    @GetMapping
    public List<SchoolSubjectGradeDto> findAllAvg() {
        return userService.findAllAvg();
    }
    @GetMapping("/{id}")
    public List<SchoolSubjectGradeDto> findById(@PathVariable int id) {
        return userService.findById(id);
    }
}
