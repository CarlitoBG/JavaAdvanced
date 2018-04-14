package StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13SentenceExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyword = scanner.nextLine();
        String text = scanner.nextLine();

        String regex = "[A-Za-z0-9].+?[.!?]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (matcher.group().contains(" " + keyword + " ")) {
                System.out.println(matcher.group());
            }
        }
    }
}