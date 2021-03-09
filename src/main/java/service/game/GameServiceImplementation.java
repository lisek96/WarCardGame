package service.game;

import model.game.Result;
import repository.game.GameDao;

import javax.inject.Inject;
import java.sql.SQLException;

public class GameServiceImplementation implements GameService {

    @Inject
    GameDao gameDao;

    @Override
    public void setGameResult(Result gameResult) throws SQLException {
        int idGame = decryptGameID(gameResult.getGameId());
        String result = gameResult.getWinner();
        gameDao.setResultByGameID(idGame, result);
    }

    @Override
    public int createNewGameAndReturnID(int idUser) {
        return gameDao.create(idUser);
    }

    @Override
    public int encryptGameID(int gameID) {
        return (gameID +41) * 3 * 7 * 11 * 27;
    }

    @Override
    public int decryptGameID(int gameID) {
        return gameID / 27 / 11 / 7 / 3 - 41;
    }
}
