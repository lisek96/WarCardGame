package model.user;

public class Stats {
    int wins;
    int loses;
    int matches;
    double winPercentage;
    int ranking;

    public Stats(int wins, int loses, int matches, double winPercentage, int ranking) {
        this.wins = wins;
        this.loses = loses;
        this.matches = matches;
        this.winPercentage = winPercentage;
        this.ranking = ranking;
    }
}
