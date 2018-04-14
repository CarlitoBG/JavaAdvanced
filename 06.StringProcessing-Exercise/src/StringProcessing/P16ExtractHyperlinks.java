package StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P16ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder text = new StringBuilder();

        while (!line.equals("END")){

            text.append(line);

            line = scanner.nextLine();
        }

        Pattern regex = Pattern.compile("<a[^>]*?href\\s*=\\s*(\"*)('*)([^>]+?[a-z:/.]*)\\2\\1[^>]*?>");
        Matcher matcher = regex.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(3));
        }
    }
}