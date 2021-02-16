package repository.user;

import model.User;
import repository.SQL_Server_DBConnectionProvider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL_Server_UserDAO implements UserDAO {
    @Override
    public void create(User user) {
        CallableStatement callableStatement = null;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC createNewUser ?, ?, ?, ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, user.getLogin());
            callableStatement.setString(2, user.getPassword());
            callableStatement.setString(3, user.getSalt());
            callableStatement.setString(4, user.getEmail());
            callableStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getIDByLogin(String login) {
        CallableStatement callableStatement = null;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try

                (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getIDByLogin ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, login);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getIDByEmail(String email) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try

                (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getIDByEmail ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, email);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getPasswordByLogin(String login) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try

                (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getPasswordByLogin ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, login);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) return resultSet.getString(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getSaltByLogin(String login) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try

                (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getSaltByLogin ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, login);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) return resultSet.getString(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setActivated(boolean status, long id) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try

                (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC setActivated ? ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            if (status == false) callableStatement.setString(1, "0");
            if (status == true) callableStatement.setString(1, "1");
            callableStatement.setString(2, Long.toString(id));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
