package service.game;

import model.game.Result;

public interface GameService {
    void setGameResult(Result gameResult);
    int createNewGameAndReturnID(int idUser);
    int encryptGameID(int gameID);
    int decryptGameID(int gameID);
}
