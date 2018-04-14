package StringProcessing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P03TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> bannedWords = new HashSet<>(Arrays.asList(scanner.nextLine().split(", ")));
        StringBuilder text = new StringBuilder(scanner.nextLine());

        for (String bannedWord: bannedWords) {
            int startIndex = text.indexOf(bannedWord);
            int wordLength = bannedWord.length();
            String stars = stringRepeat(wordLength);

            while (startIndex >= 0){
                text.replace(startIndex,startIndex + wordLength, stars);
                startIndex = text.indexOf(bannedWord);
            }
        }

        System.out.println(text);
    }

    private static String stringRepeat(int wordLength) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < wordLength; i++) {
            result.append("*");
        }
        return result.toString();
    }
}