package models;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //1. feladat

        List<Match> matches = new ArrayList<>();

        Map<Worldcup, List<Match>> mapMatches = new HashMap<>();

        List<Worldcup> worldcups = new ArrayList<>();

        String nextLine = "";

        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("matches_all.csv"))){
                String line;
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    Match data = new Match(line);
                    matches.add(data);
                }
            }

            try (BufferedReader reader = new BufferedReader(new FileReader("worldcups.csv"))){
                String line;
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    Worldcup data = new Worldcup(line);
                    worldcups.add(data);
                }
            }

            System.out.println("Beolvasott meccsek száma: " + matches.size());
            //System.out.println("Beolvasott VB-k száma: " + worldcups.size());

            for (Match match : matches) {
                for (Worldcup worldcup : worldcups) {
                    if (match.getYear() == worldcup.getYear()) {
                        if (!mapMatches.containsKey(worldcup)) {
                            mapMatches.put(worldcup, new ArrayList<>());
                        }
                        List<Match> subList = mapMatches.get(worldcup);
                        subList.add(match);
                    }
                }
            }

            System.out.println("Name of host:");
            Scanner scanner = new Scanner(System.in);
            nextLine = scanner.nextLine();

        } catch (IOException e) {
            //e.printStackTrace();
            System.err.print("Fájbeolvasási hiba!");
        }

        Worldcup selected = null;
        for (Worldcup worldcup : worldcups) {
            if (nextLine.equals(worldcup.getHost())) {
                selected = worldcup;
                break;
            }
        }
        if (selected == null) {
            System.err.print("Nem szerepel a listában ilyen ország!");
            return;
        }

        //2. feladat

        int mostScoreDifference = 0;
        for (Match match : matches) {
            if (selected.getYear() == match.getYear()) {
                if (Math.abs(match.getGoals_a() - match.getGoals_b()) > mostScoreDifference) {
                    mostScoreDifference = Math.abs(match.getGoals_a() - match.getGoals_b());
                }
            }
        }

        System.out.println("2. Maximum goal difference: " + mostScoreDifference);

        //3. feladat

        int AWinner = 0;
        for (Match match : matches) {
            if (selected.getYear() == match.getYear()) {
                if (match.getGoals_a() > match.getGoals_b()) {
                    AWinner++;
                } /*else if ((match.getGoals_a() == match.getGoals_b() && match.getPenalties_a() > match.getPenalties_b()) && !match.getStage().contains("Group") ){
                    AWinner++;
                }*/
            }
        }

        System.out.println("3. The player has won: " + AWinner + " bets.");

        //4. feladat
        System.out.println("4. Total goals by stage: ");
        Map<String, Integer> stageGoals = new LinkedHashMap<>();
        for (Match match : matches) {
            if (selected.getYear() == match.getYear()) {
                int count = stageGoals.getOrDefault(match.getStage(), 0);
                stageGoals.put(match.getStage(), count + match.getGoals_a() + match.getGoals_b());
            }
        }

        for (String stage : stageGoals.keySet()) {
            System.out.println(stage + ": " + stageGoals.get(stage));
        }

        //1. feladat

        try {
            try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("selected.csv")))) {
                writer.println("year;stage;date;team_a;team_b;goals_a;goals_b;penalties_a;penalties_b");

                for (Match match : mapMatches.get(selected)) {
                    writer.print(match.getStage() + ";" + match.getDate() + ";" + match.getTeam_a() + ";"
                            + match.getTeam_b() + ";" + match.getGoals_a() + ";" + match.getGoals_b());
                    if (!match.getStage().contains("Group") && match.getGoals_a() == match.getGoals_b()) {
                        writer.println(";" + match.getPenalties_a() + ";" + match.getPenalties_b());
                    } else {
                        writer.print("\n");
                    }
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.err.print("Fájlírási hiba!");
        }
    }
}
