package services;

import DB.DAO.UserDAOImpl;
import DB.DAO.UserDao;
import pojo.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
