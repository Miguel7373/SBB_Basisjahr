package com.example.demo.Controller;

import com.example.demo.Dtos.SubjectDto;
import com.example.demo.services.AdminService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Profile("admin")

@RestController
@RequestMapping("/api/admin")
public class SubjectAdminController {
    private final AdminService adminService;

    public SubjectAdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/newSubject")
    public void createNewSubject(@RequestBody SubjectDto newSubject) {
        adminService.createNewSubject(newSubject);
    }
    @PutMapping("/editSubject/{id}")
    public void editSubject(@PathVariable int id ){
        adminService.editSubject(2);
    }
    @DeleteMapping("/deleteSubject/{id}")
    public void deleteSubject(@PathVariable int id){
        adminService.deleteSubject(1);
    }

    @GetMapping("/findAll")
    public List<SubjectDto> findAll() {
        return adminService.findAll();
    }

}
