package servlets;

import DB.DAO.StudentDAO;
import pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding ("Cp1251");
        resp.getWriter().println("Hello");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding ("Cp1251");

        StudentDAO studentDAO = new StudentDAO();
        try {
            List<Student> students = studentDAO.getAll();
            req.setAttribute("list", students);
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/hello.jsp").forward(req, resp);

    }
}
