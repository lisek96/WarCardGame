package repository.game;

import model.activactionLink.ActivationLink;
import repository.connection.SQL_Server_DBConnectionProvider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL_Server_GameDAO implements GameDao {
    @Override
    public int create(int idUser) {
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC createGame ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setInt(1, idUser);
            ResultSet resultSet = callableStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setResultByGameID(int idGame, String result) throws SQLException{
        CallableStatement callableStatement;
        SQL_Server_DBConnectionProvider sql_server_dbConnectionProvider = new SQL_Server_DBConnectionProvider();
        try (Connection connection = sql_server_dbConnectionProvider.provideConnection()) {
            String sql = "EXEC setResultByGameID ?, ?";
            callableStatement = connection.prepareCall(sql);
            callableStatement.setEscapeProcessing(true);
            callableStatement.setInt(1, idGame);
            callableStatement.setString(2, result);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
