package repository.game;

public interface GameDao {
    int create(int idUser);
    void setResultByGameID(int idGame, String result);
}
