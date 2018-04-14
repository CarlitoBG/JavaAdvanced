package StringProcessing;

import java.util.Scanner;

public class P04UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        StringBuilder result = new StringBuilder();

        for (char character : input) {
            result.append(String.format("\\u%04x", (int)character));
        }

        System.out.println(result);
    }
}