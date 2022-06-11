package models2;

public class HasPenelties extends Match{

    public HasPenelties(int year, String stage, String date, String team_a, String team_b, int goals_a, int goals_b, int penalties_a, int penalties_b) {
        super(year, stage, date, team_a, team_b, goals_a, goals_b, penalties_a, penalties_b);
    }

    public boolean AWinner() {
        return penalties_a > penalties_b;
    }
}
