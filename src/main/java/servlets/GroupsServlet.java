package servlets;

import DB.DAO.GroupDAO;
import DB.DAO.StudentDAO;
import pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
