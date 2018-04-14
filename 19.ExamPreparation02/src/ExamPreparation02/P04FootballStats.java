package ExamPreparation02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> stats = new HashMap<>();

        while (true){
            String input = reader.readLine();

            if("Season End".equals(input)) {
                break;
            }

            String[] line = input.split("\\s+");

            String team = line[0];
            String opponent = line[2];
            String[] score = line[4].split(":");

            fillMap(team, opponent, score[0],score[1], stats);
            fillMap(opponent, team, score[1], score[0], stats);
        }

        String[] teams = reader.readLine().split(", ");

        for (String team : teams) {
            stats.get(team)
                    .stream()
                    .sorted(Comparator.comparing(a -> a.split(" -> ")[0]))
                    .forEach(System.out::println);
        }
    }

    private static void fillMap(String team, String opponent, String teamScore, String opponentScore,
                                Map<String, List<String>> stats) {

        if(!stats.containsKey(team)) {
            stats.put(team, new ArrayList<>());
        }
        stats.get(team).add(team + " - " + opponent + " -> " + teamScore + ":" + opponentScore);
    }
}