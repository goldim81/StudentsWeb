package students.servlets;

import students.services.AuthService;
import students.services.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static AuthService authService = new AuthServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (authService.auth(login, password)) {
            req.getSession().setAttribute("isAuth", true);
//            req.getRequestDispatcher("/students").forward(req, resp);
            ((HttpServletResponse) resp).sendRedirect("/student/students");
        } else {
            getServletContext().getRequestDispatcher("/").forward(req, resp);
        }
    }
}
