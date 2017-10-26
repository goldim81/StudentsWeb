package students.services;

import students.DB.DAO.UserDAOImpl;
import students.pojo.User;

public interface RegistrationService {
    public User regUser(String login, String pass) throws UserDAOImpl.UserDAOException;
}
