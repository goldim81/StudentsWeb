package students.servlets;

import students.DB.DAO.UserDAOImpl;
import students.services.AuthService;
import students.services.AuthServiceImpl;
import students.services.RegistrationService;
import students.services.RegistrationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUserServlet extends HttpServlet {
    private static RegistrationService rs = new RegistrationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if (rs.regUser(login, password)!=null) {
                ((HttpServletResponse) resp).sendRedirect("/student");
            } else {
                resp.getWriter().print("Ошибка");
            }
        } catch (UserDAOImpl.UserDAOException e) {
            e.printStackTrace();
        }
    }
}
