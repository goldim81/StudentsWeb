package services;

import DB.DAO.UserDAOImpl;
import pojo.User;

public interface RegistrationService {
    public User regUser(String login, String pass) throws UserDAOImpl.UserDAOException;
}
