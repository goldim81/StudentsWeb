package students.DB.DAO;

import students.DB.ConnectionManagerPostgreSQL;
import students.DB.IConnectionManager;
import students.pojo.Student;
import students.pojo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDao {
    @Override
    public User getUserByLoginAndPassword(String login, String password) throws UserDAOException {
        PreparedStatement statement = null;
        try {
            statement = manager.getConnection().prepareStatement("SELECT * FROM users WHERE login = ? and password = ? ");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())  return new User(login);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserDAOException();
        }

        return null;
    }
    private PreparedStatement getInsertStatement() throws SQLException {
        return manager.getConnection().prepareStatement(
                "INSERT INTO users (login, password) " +
                        "VALUES  (?, ?)");
    }
    @Override
    public boolean createUser(User user) throws UserDAOException {

            PreparedStatement statement = null;
            try {
                statement = getInsertStatement();
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new UserDAOException();
            }

        return true;

    }

    public static class UserDAOException extends Exception {

    }
    private static IConnectionManager manager;

    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }

}
