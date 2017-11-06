package students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import students.DB.entitys.StudentEntitys;
import students.services.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class StudentsController {
    @Autowired
    StudentService service;


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView showStudentList(){
        ModelAndView modelAndView = new ModelAndView("students");
        List<StudentEntitys> students = service.getAllStudents();
        modelAndView.addObject("list", students);
        return modelAndView;
    }

    @RequestMapping(value = "/delstudent", method = RequestMethod.GET)
    public String delById(@RequestParam(name = "del_by_id") int idStudent) {
        service.delStudentById(idStudent);
        return "redirect:/students";
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.GET)
    public String getViewAddStudent(){
        return "addstudent";
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public String addStudent(HttpServletRequest req)
    {
        try {
            req.setCharacterEncoding("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String firstName = req.getParameter("firstname");
        String secondname = req.getParameter("secondname");
        String familyname = req.getParameter("familyname");
        String birthday = req.getParameter("birthday");
        int groupId = Integer.parseInt(req.getParameter("groupid"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthday, formatter);

        StudentEntitys student = new StudentEntitys(service.getGroupById(groupId), firstName, secondname, familyname, date);
        service.addStudent(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/editstudent", method = RequestMethod.GET)
    public ModelAndView editStudent(@RequestParam(name = "edit_by_id") int idStudent){
        ModelAndView modelAndView = new ModelAndView("editstudent");
        StudentEntitys student = service.getStudentById(idStudent);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping(value = "/editstudent", method = RequestMethod.POST)
    public String updateStudent(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firsname");
        String secondname = req.getParameter("secondname");
        String familyname = req.getParameter("familyname");
        String birthday = req.getParameter("birthday");
        int groupId = Integer.parseInt(req.getParameter("groupid"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthday, formatter);
        StudentEntitys student = new StudentEntitys(id, service.getGroupById(groupId), firstName, secondname, familyname, date);
        service.updateStudent(student);
        return "redirect:/students";
    }


}
