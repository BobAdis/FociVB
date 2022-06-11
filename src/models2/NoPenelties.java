package models2;

public class NoPenelties extends Match{

    public NoPenelties(int year, String stage, String date, String team_a, String team_b, int goals_a, int goals_b) {
        super(year, stage, date, team_a, team_b, goals_a, goals_b);
    }

    @Override
    public boolean AWinner() {
        return goals_a > goals_b;
    }
}
