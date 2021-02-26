package model.game;

public class Result {
    int gameId;
    String winner;

    public Result(int gameId, String winner) {
        this.gameId = gameId;
        this.winner = winner;
    }

    Result(){}

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "ResultServlet{" +
                "gameId=" + gameId +
                ", winner='" + winner + '\'' +
                '}';
    }
}
