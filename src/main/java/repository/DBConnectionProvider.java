package repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnectionProvider {
    Connection provideConnection() throws ClassNotFoundException, SQLException;
}
