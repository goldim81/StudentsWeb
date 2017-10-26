package students.servlets;

import students.DB.DAO.GroupDAO;
import students.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GroupsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding ("Cp1251");
        GroupDAO grouDAO = new GroupDAO();
//        try {
////            List<Student> students = grouDAO.getAll();
////            for (Student student : students) {
////                resp.getWriter().println(student+"\n");
////            }
//        } catch (StudentDAO.StudentDAOException e) {
//            e.printStackTrace();
//        }
    }
}
