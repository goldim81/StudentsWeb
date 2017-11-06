package students.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import students.DB.entitys.StudentEntitys;
import students.services.StudentService;

@RestController
@RequestMapping(value = "/stud")
public class RestStudentController {
    StudentService service;

    public RestStudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StudentEntitys getStudent(@PathVariable int id) {
        return service.getStudentById(id);

    }
}
