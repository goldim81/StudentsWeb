package students.DB;

import java.sql.Connection;

public interface IConnectionManager {
    Connection getConnection();
}
