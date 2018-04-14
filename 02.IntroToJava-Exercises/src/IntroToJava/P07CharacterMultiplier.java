package IntroToJava;

import java.util.Scanner;

public class P07CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.next("\\w+");
        String secondString = scanner.next("\\w+");

        int shorterStringLength = Math.min(firstString.length(), secondString.length());

        int sum = 0;
        for (int i = 0; i < shorterStringLength; i++) {
            sum += firstString.charAt(i) * secondString.charAt(i);
        }

        String longerString;
        if (firstString.length() > secondString.length()) {
            longerString = firstString;
        } else {
            longerString = secondString;
        }

        for (int i = shorterStringLength; i < longerString.length(); i++) {
            sum += longerString.charAt(i);
        }

        System.out.println(sum);
    }
}