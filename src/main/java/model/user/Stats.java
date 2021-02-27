package model.user;

public class Stats {
    String login;
    int wins;
    int loses;
    int matches;
    double winPercentage;
    int ranking;

    public Stats(String login,int wins, int loses, int matches, double winPercentage, int ranking) {
        this(wins, loses, matches, winPercentage, ranking);
        this.login=login;
    }

    public Stats(int wins, int loses, int matches, double winPercentage, int ranking) {
        this.wins = wins;
        this.loses = loses;
        this.matches = matches;
        this.winPercentage = winPercentage;
        this.ranking = ranking;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Stats(){

    }

    public String getLogin() {
        return login;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getMatches() {
        return matches;
    }

    public double getWinPercentage() {
        return winPercentage;
    }

    public int getRanking() {
        return ranking;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "ranking=" + ranking +
                '}';
    }
}
