package repository.activationLink;

import model.activactionLink.ActivationLink;
import repository.SQL_Server_DBConnectionProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQL_Server_ActivationLinkDAO implements ActivationLinkDAO {
    @Override
    public void create(ActivationLink activationLink) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC createActivationLink ?, ?, ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, Long.toString(activationLink.getIdUser()));
            callableStatement.setString(2, activationLink.getToken());
            callableStatement.setString(3, activationLink.getExpirationDate());
            callableStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void deleteByToken(String token) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC deleteActivationLinkByToken ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1,token);
            callableStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getIDUserByToken(String token) {
        CallableStatement callableStatement = null;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC getIDUserByToken ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setString(1, token);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) return resultSet.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
