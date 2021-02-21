package repository.connection;

import repository.connection.DBConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL_Server_DBConnectionProvider implements DBConnectionProvider {
    final static String dbUrl = "jdbc:sqlserver://mssql-20436-0.cloudclusters.net:20480;databaseName=WarCardGame;user=admin;password=qweqwe12Q11;";
    @Override
    public Connection provideConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(dbUrl);
    }
}
