import DB.DAO.LogDAO;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MyAppender extends AppenderSkeleton {
    @Override
    protected void append(LoggingEvent event) {
        LogDAO logDAO = new LogDAO();
        logDAO.insertMessage(event);

    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
