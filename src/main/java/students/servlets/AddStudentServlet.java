package students.servlets;

import students.DB.DAO.StudentDAO;
import students.pojo.Group;
import students.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addstudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        int id = Integer.decode(req.getParameter("id"));
        String firstName = req.getParameter("firsname");
        String secondname = req.getParameter("secondname");
        String familyname = req.getParameter("familyname");
        String birthday = req.getParameter("birthday");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        formatter = formatter.withLocale(Locale.);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        LocalDate date = LocalDate.parse(birthday, formatter);
        int groupid = Integer.decode(req.getParameter("groupid"));

        Student student = new Student(id,firstName, secondname, familyname, date);
        student.setGroup(new Group(1, "Группа1"));
        StudentDAO studentDAO = new StudentDAO();
        try {
            studentDAO.insertOne(student);
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }
        ((HttpServletResponse) resp).sendRedirect("/student/students");
    }
}
