package service.game;

import repository.game.GameDao;

import javax.inject.Inject;

public class GameServiceImplementation implements GameServiceInterface{
    @Inject
    GameDao gameDao;

    @Override
    public int setResultByGameID(int idGame) {
        return 0;
    }

    @Override
    public int createNewGameAndReturnID(int idUser) {
        return 0;
    }
}
