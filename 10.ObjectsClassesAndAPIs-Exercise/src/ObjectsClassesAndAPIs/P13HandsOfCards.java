package ObjectsClassesAndAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class P13HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Map<String, HashSet<String>> personCardsPair = new LinkedHashMap<>();

        while (!line.equals("JOKER")){

            String[] splitLine = line.split(": ");
            String playersName = splitLine[0];
            HashSet<String> cards = new HashSet<>(Arrays.asList(splitLine[1].split(", ")));

            if (!personCardsPair.containsKey(playersName)){
                personCardsPair.put(playersName, cards);
            }
            personCardsPair.get(playersName).addAll(cards);

            line = reader.readLine();
        }

        personCardsPair.forEach((person, cards) -> System.out.printf("%s: %d%n", person, calcScore(cards)));
    }

    private static int calcScore(HashSet<String> cards) {

        int score = 0;
        for (String card : cards) {
            score += getValue(card);
        }

        return score;
    }

    private static int getValue(String card) {
        int type;
        switch (card.charAt(card.length() - 1)) {
            case 'S':
                type = 4;
                break;
            case 'H':
                type = 3;
                break;
            case 'D':
                type = 2;
                break;
            default:
                type = 1;
                break;
        }

        int power;
        switch (card.charAt(0)) {
            case 'J':
                power = 11;
                break;
            case 'Q':
                power = 12;
                break;
            case 'K':
                power = 13;
                break;
            case 'A':
                power = 14;
                break;
            default:
                power = Integer.parseInt(card.substring(0, card.length() - 1));
                break;
        }

        return power * type;
    }
}