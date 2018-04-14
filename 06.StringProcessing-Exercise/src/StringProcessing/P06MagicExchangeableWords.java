package StringProcessing;

import java.util.HashSet;
import java.util.Scanner;

public class P06MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        HashSet<Character> firstSet = new HashSet<>();
        HashSet<Character> secondSet = new HashSet<>();

        for (int i = 0; i < words[0].length(); i++) {
            firstSet.add(words[0].charAt(i));
        }

        for (int i = 0; i < words[1].length(); i++) {
            secondSet.add(words[1].charAt(i));
        }

        System.out.println(firstSet.size() == secondSet.size() ? "true" : "false");
    }
}