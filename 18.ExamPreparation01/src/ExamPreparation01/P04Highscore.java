package ExamPreparation01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> playerPoints = new LinkedHashMap<>();
        Map<String, List<String>> playerOpponents = new HashMap<>();

        while (true){
            String[] line = reader.readLine().split("\\s+");

            if("osu!".equals(line[0])) {
                break;
            }

            Integer player1Points = Integer.valueOf(line[0]);
            Integer player2Points = Integer.valueOf(line[2]);
            String[] names = line[1].split("<->");

            fillMaps(names[0], names[1], playerOpponents, playerPoints, player1Points, player2Points);
            fillMaps(names[1], names[0], playerOpponents, playerPoints, player2Points, player1Points);
        }

        StringBuilder result = new StringBuilder();

        playerPoints.entrySet().stream().sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
                .forEach(v -> {
                    result.append(v.getKey()).append(" - (").append(v.getValue()).append(")").append("\n");
                    playerOpponents.get(v.getKey()).forEach(s -> result.append(s).append("\n"));
                });

        System.out.println(result);
    }

    private static void fillMaps(String playerName, String opponentName, Map<String, List<String>> playerOpponents,
                                 Map<String, Long> playerPoints, Integer player1Points, Integer player2Points) {

        if(!playerPoints.containsKey(playerName)) {
            playerPoints.put(playerName, 0L);
        }
        playerPoints.put(playerName, playerPoints.get(playerName) + (player1Points - player2Points));

        if(!playerOpponents.containsKey(playerName)) {
            playerOpponents.put(playerName, new ArrayList<>());
        }
        playerOpponents.get(playerName).add("*   " + opponentName + " <-> " + (player1Points - player2Points));
    }
}