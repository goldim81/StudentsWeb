package services;

import DB.DAO.UserDAOImpl;
import DB.DAO.UserDao;

public class AuthServiceImpl implements AuthService {
    private static UserDao userDao = new UserDAOImpl();

    @Override
    public boolean auth(String login, String pass) {
        if (login==null || pass==null) return false;
        try {
            if (userDao.getUserByLoginAndPassword(login, PasswordEncoder.md5(pass))!=null) return true;
        } catch (UserDAOImpl.UserDAOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
