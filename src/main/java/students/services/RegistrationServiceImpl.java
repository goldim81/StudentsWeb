package students.services;

import students.DB.DAO.UserDAOImpl;
import students.DB.DAO.UserDao;
import students.pojo.User;

public class RegistrationServiceImpl implements RegistrationService {

    private static UserDao userDao = new UserDAOImpl();

    @Override
    public User regUser(String login, String pass) throws UserDAOImpl.UserDAOException {
        if (login==null || pass==null) return null;
        User user = new User(login, PasswordEncoder.md5(pass));
        if (userDao.createUser(user)) return user;
        return null;
    }


}
