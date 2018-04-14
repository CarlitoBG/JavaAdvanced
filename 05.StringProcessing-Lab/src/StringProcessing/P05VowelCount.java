package StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("[AEIOUYaeiouy]");
        Matcher matcher = pattern.matcher(input);

        int vowelCount = 0;
        while (matcher.find()){
            vowelCount++;
        }

        System.out.printf("Vowels: %d", vowelCount);
    }
}