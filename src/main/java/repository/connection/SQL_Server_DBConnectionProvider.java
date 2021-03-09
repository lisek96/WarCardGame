package repository.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class SQL_Server_DBConnectionProvider implements DBConnectionProvider {
    @Override
    public Connection provideConnection() throws SQLException {
        return ConnectionProvider.getConnection();
    }
}
