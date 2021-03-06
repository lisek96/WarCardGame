package repository.user;

import model.user.User;
import repository.utils.Helper;
import repository.connection.SQL_Server_DBConnectionProvider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


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
            callableStatement.setString(2, user.getSalt());
            callableStatement.setString(3, user.getPassword());
            callableStatement.setString(4, user.getEmail());
            callableStatement.execute();
        } catch (SQLException e ){
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getIDByEmail(String email) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getIDByEmail ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, email);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String[] getIdAndEmailByLogin(String login) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getIdAndEmailByLogin ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, login);
            ResultSet rs = callableStatement.executeQuery();
            rs.next();
            return new String[]{rs.getString(1), rs.getString(2)};

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getEmailByLogin(String login) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try

                (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getEmailByLogin ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, login);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) return resultSet.getString(1);
        } catch (SQLException e) {
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
        } catch (SQLException e) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setActivated(boolean status, int id) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC setActivated ?, ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            if (status == true)
                callableStatement.setString(1, "true");
            else
                callableStatement.setString(1, "false");
            callableStatement.setInt(2, id);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isUserActivated(String login) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC isUserActivated ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, login);
            ResultSet info = callableStatement.executeQuery();
            info.next();
            String isActivated = info.getString(1);
            if (isActivated.equals("true")) return true;
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int[] getWinsAndLoses(int userId) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getWinsAndLoses ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setInt(1, userId);
            ResultSet rs = callableStatement.executeQuery();
            rs.next();
            return new int[]{rs.getInt(1), rs.getInt(2)};

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void incrementWins(int idUser) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC incrementWins ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setInt(1, idUser);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void incrementLoses(int idUser) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC incrementLoses ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setInt(1, idUser);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<List<String>> getLoginWinsLosesOfUsers(int howMany) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getLoginWinsLosesOfUsers ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setInt(1, howMany);
            ResultSet rs = callableStatement.executeQuery();
            List<List<String>> listOfRows = Helper.getAllRowsFromResultSetIntoStringList(rs, 3);
            return listOfRows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
