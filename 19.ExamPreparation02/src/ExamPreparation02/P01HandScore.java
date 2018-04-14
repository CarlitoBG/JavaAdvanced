package ExamPreparation02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P01HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] cards = reader.readLine().split("\\s+");

        String lastSuit = "";
        List<Integer> sumOfSameSuit = new ArrayList<>();
        int handScore = 0;

        for (String card : cards) {
            String currentSuit = card.substring(card.length() - 1);
            int cardValue = getCardValue(card.substring(0, card.length() - 1));

            if (lastSuit.equals(currentSuit)){
                sumOfSameSuit.add(cardValue);
            }else {
                handScore += sumOfSameSuit.stream().reduce(0, Integer::sum) * sumOfSameSuit.size();
                sumOfSameSuit.clear();
                sumOfSameSuit.add(cardValue);
                lastSuit = currentSuit;
            }
        }

        handScore += sumOfSameSuit.stream().reduce(0, Integer::sum) * sumOfSameSuit.size();
        System.out.println(handScore);
    }

    private static int getCardValue(String cardFace) {
        switch (cardFace) {
            case "J":
                return 12;
            case "Q":
                return 13;
            case "K":
                return 14;
            case "A":
                return 15;
            default:
                return Integer.parseInt(cardFace);
        }
    }
}