package IntroToJava;

import java.util.Scanner;

public class P11GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Integer maxScore = Integer.MIN_VALUE;
        String winnerName = "";

        for (int i = 0; i < n; i++) {
            String playerName = scanner.nextLine();
            int initialPoints = Integer.parseInt(scanner.nextLine());

            int currentPoints = 0;

            for (int j = 0; j < playerName.length(); j++) {
                char currentChar = playerName.charAt(j);

                if (currentChar % 2 == 0){
                    currentPoints += currentChar;
                }else {
                    currentPoints -= currentChar;
                }
            }

            int playerTotalScore = initialPoints + currentPoints;

            if (playerTotalScore > maxScore){
                maxScore = playerTotalScore;
                winnerName = playerName;
            }
        }

        System.out.printf("The winner is %s - %d points", winnerName, maxScore);
    }
}