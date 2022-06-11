package models2;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //1. feladat

        List<Match> matches = new ArrayList<>();

        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("matches_all.csv"))) {
                String line;
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] data = line.split(";");
                        String[] values = new String[9];
                        if (data.length < 8) {
                            for (int i = 0; i < data.length; i++) {
                                values[i] = data[i];
                            }
                            values[7] = "0";
                            values[8] = "0";
                        } else {
                            values = data;
                        }
                        Match match = MatchFactory.createMatch(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4],Integer.parseInt(values[5]),Integer.parseInt(values[6]),Integer.parseInt(values[7]),Integer.parseInt(values[8]));
                        matches.add(match);
                    }catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println("Hibás sor figyelmen kívül hagyása...");
                    }
                }
            }

            System.out.println("Beolvasott meccsek száma: " + matches.size());

            System.out.println("Year of worldcup:");
            Scanner scanner = new Scanner(System.in);
            int nextLine = Integer.parseInt(scanner.nextLine());
            int counter = 0;
            for (Match match : matches) {
                if (nextLine == match.getYear()) {
                    if (match.AWinner()) {
                        counter++;
                    }
                }
            }

            System.out.println("Winner 'A': " + counter);

        } catch (IOException e) {
            //e.printStackTrace();
            System.err.print("Fájbeolvasási hiba!");
        }
    }
}
