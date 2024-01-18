package Controller;

import Dtos.SubjectDto;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class SubjectAdminController {
    @PostMapping("/subject")
    public SubjectDto createNewSubject(@RequestBody SubjectDto newSubject) {
        // TODO: Das sind Mockdaten und sollten zu einem späteren Zeitpunkt mit "echtem" Code ersetzt werden
        return new SubjectDto("Physik");
    }
    // hier können weitere Methoden der Schnittstelle umgesetzt werden
    @PutMapping("/{id}")
    public Order editSubject(@PathVariable Long id , String name){
        // TODO: Das sind Mockdaten und sollten zu einem späteren Zeitpunkt mit "echtem" Code ersetzt werden
        return editSubject(2,"Physiks");
    }
    @DeleteMapping("/{id}")
    public SubjectDto deleteSubject(@PathVariable Long id){
        return (null);
    }

    @GetMapping()
    public List<Order> findAll() {
        return orderService.findAll();
    }

}
