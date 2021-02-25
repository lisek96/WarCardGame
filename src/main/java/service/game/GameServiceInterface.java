package service.game;

public interface GameServiceInterface {
    int setResultByGameID(int idGame);
    int createNewGameAndReturnID(int idUser);
}
