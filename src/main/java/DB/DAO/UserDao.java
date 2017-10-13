package DB.DAO;

import pojo.User;

public interface UserDao {
    User getUserByLoginAndPassword(String login, String password) throws UserDAOImpl.UserDAOException;

    public boolean createUser(User user) throws UserDAOImpl.UserDAOException;
}
