package students.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import students.services.AuthService;
import students.services.AuthServiceImpl;

@Controller
public class LoginController {
    private AuthService authService = new AuthServiceImpl();

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String login(@RequestParam(name = "login") String login,
                        @RequestParam(name = "password") String password)
    {
        if (authService.auth(login, password)) {
            return "redirect:/students";
        } else {
            return "forward:/";
        }

    }
}
