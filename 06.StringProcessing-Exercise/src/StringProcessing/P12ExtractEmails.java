package StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(?<=(\\s|^))([a-z0-9][-._]*)+[a-z0-9]+@(([a-z][-]*)+[a-z]+\\.)+[a-z]+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}