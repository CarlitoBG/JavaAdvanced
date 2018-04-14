package StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P11ReplaceATag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder input = new StringBuilder();

        while (!line.equals("END")){

            input.append(line).append("\n");

            line = scanner.nextLine();
        }

        Pattern pattern = Pattern.compile("(<a\\s+href\\s*=\\s*)(.+?)(>)(\\n?.+?)(<\\/a>)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String replacement = "[URL href=" + matcher.group(2) + "]" + matcher.group(4) + "[/URL]";
            input.replace(matcher.start(), matcher.end(), replacement);
            matcher = pattern.matcher(input);
        }

        System.out.println(input);
    }
}