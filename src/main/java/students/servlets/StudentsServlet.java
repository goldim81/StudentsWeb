package students.servlets;

import students.DB.DAO.StudentDAO;
import students.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding ("Cp1251");
        StudentDAO studentDAO = new StudentDAO();
        try {
            List<Student> students = studentDAO.getAll();
            req.setAttribute("list", students);
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }
}
