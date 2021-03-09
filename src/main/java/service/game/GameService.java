package service.game;

import model.game.Result;

import java.sql.SQLException;

public interface GameService {
    void setGameResult(Result gameResult) throws SQLException;
    int createNewGameAndReturnID(int idUser);
    int encryptGameID(int gameID);
    int decryptGameID(int gameID);
}
