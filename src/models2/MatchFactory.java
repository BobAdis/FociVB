package models2;

public class MatchFactory {
    public static Match createMatch(int year, String stage, String date, String team_a, String team_b, int goals_a, int goals_b, int penalties_a, int penalties_b) {
        if (penalties_a == 0 && penalties_b == 0) {
            return new NoPenelties(year, stage, date, team_a, team_b, goals_a, goals_b);
        } else {
            return new HasPenelties(year, stage, date, team_a, team_b, goals_a, goals_b, penalties_a, penalties_b);
        }
    }
}
