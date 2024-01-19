package Controller;

import Dtos.SubjectDto;
import Services.AdminService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Profile("Admin")
@RestController
@RequestMapping("/api/admin/subject")
public class SubjectAdminController {
    private final AdminService adminService;

    public SubjectAdminController(AdminService orderService) {
        this.adminService = orderService;
    }

    @PostMapping
    public void createNewSubject(@RequestBody SubjectDto newSubject) {
        adminService.createNewSubject(newSubject);
    }
    @PutMapping("/{id}")
    public void editSubject(@PathVariable int id ){
        adminService.editSubject(2);
    }
    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable int id){
        adminService.deleteSubject(1);
    }

    @GetMapping("/all")
    public List<SubjectDto> findAll() {
        return adminService.findAll();
    }

}
