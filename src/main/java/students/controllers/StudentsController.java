package students.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import students.DB.DAO.StudentDAO;
import students.pojo.Group;
import students.pojo.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class StudentsController {

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView showStudentList(){
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students=null;
        try {
            students = studentDAO.getAll();
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("students");
        modelAndView.addObject("list", students);
        return modelAndView;
    }

    @RequestMapping(value = "/delstudent", method = RequestMethod.GET)
    public String delById(@RequestParam(name = "del_by_id") int idStudent) {
        StudentDAO studentDAO = new StudentDAO();
        try {
            studentDAO.deleteByID(idStudent);
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }
        return "redirect:/students";
    }

    @RequestMapping(value = "/editstudent", method = RequestMethod.GET)
    public ModelAndView editStudent(@RequestParam(name = "edit_by_id") int idStudent){
        StudentDAO studentDAO = new StudentDAO();

        Student student = null;
        try {
            student = studentDAO.getByID(idStudent);
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editstudent");
        modelAndView.addObject("student", student);
        return modelAndView;
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
        int id = Integer.decode(req.getParameter("id"));
        String firstName = req.getParameter("firstname");
        String secondname = req.getParameter("secondname");
        String familyname = req.getParameter("familyname");
        String birthday = req.getParameter("birthday");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthday, formatter);

        Student student = new Student(id,firstName, secondname, familyname, date);
        student.setGroup(new Group(1, "Группа1"));
        StudentDAO studentDAO = new StudentDAO();
        try {
            studentDAO.insertOne(student);
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }
        return "redirect:/students";
    }

    @RequestMapping(value = "/editstudent", method = RequestMethod.POST)
    public String updateStudent(HttpServletRequest req)
    {
        try {
            req.setCharacterEncoding("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int id = Integer.decode(req.getParameter("id"));
        String firstName = req.getParameter("firsname");
        String secondname = req.getParameter("secondname");
        String familyname = req.getParameter("familyname");
        String birthday = req.getParameter("birthday");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(birthday, formatter);
        Student student = new Student(id,firstName, secondname, familyname, date);
        student.setGroup(new Group(1, "Группа1"));
        StudentDAO studentDAO = new StudentDAO();
        try {
            studentDAO.update(student);
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }
        return "redirect:/students";
    }


}
