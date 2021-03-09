package repository.game;

import java.sql.SQLException;

public interface GameDao {
    int create(int idUser);
    void setResultByGameID(int idGame, String result) throws SQLException;
}
