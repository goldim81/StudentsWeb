package students.servlets;

import students.DB.DAO.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idStudent = Integer.decode(req.getParameter("del_by_id"));
        StudentDAO studentDAO = new StudentDAO();
        try {
            studentDAO.deleteByID(idStudent);
        } catch (StudentDAO.StudentDAOException e) {
            e.printStackTrace();
        }
        ((HttpServletResponse) resp).sendRedirect("/student/students");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
