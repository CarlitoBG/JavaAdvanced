package PracticalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder();
        text.append(reader.readLine());

        String expression = reader.readLine();

        while (!"Print".equals(expression)){

            expression = expression.replaceAll("[<(\\[{\\\\^\\-=$!|\\]})‌​?*+.>]", "\\\\$0");
            expression = expression.replaceAll("%", "[^\\\\s+]*");

            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()){

                StringBuilder replacer = new StringBuilder();
                replacer.append(matcher.group());
                replacer.reverse();

                int start = text.indexOf(matcher.group());
                int end = start + matcher.group().length();
                text.replace(start, end, replacer.toString());
            }

            expression = reader.readLine();
        }

        System.out.println(text);
    }
}