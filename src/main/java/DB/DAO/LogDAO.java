package DB.DAO;

import DB.ConnectionManagerPostgreSQL;
import DB.IConnectionManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LogDAO {
    public static class LogDAOException extends Exception {

    }

    private static IConnectionManager manager;
    private static final Logger logger = Logger.getLogger(LogDAO.class);


    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }

    private String sql = "insert into log_table (level, message) values(?,?)";

    public void insertMessage(LoggingEvent event){
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement(sql);
            String message = event.getMessage().toString();
            String level = event.getLevel().toString();
            statement.setString(1, level);
            statement.setString(2, message);
            int res = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }


}
