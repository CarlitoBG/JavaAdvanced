package DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = reader.readLine();

        StringBuilder text = new StringBuilder();
        StringBuilder output = new StringBuilder();

        while (!inputLine.equals("END")){
            text.append(inputLine);

            inputLine = reader.readLine();
        }

        String regex = "(?<name>[A-Z][A-Za-z]*)[^+A-Z]*?(?<phoneNumber>\\+?\\d+[(\\d)/.\\-\\s]*\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean isMatchFound = false;

        output.append("<ol>");
        while (matcher.find()){
            isMatchFound = true;

            String name = matcher.group("name");
            String phone = matcher.group("phoneNumber").replaceAll("[()/.\\-\\s]", "");

            output.append(String.format("<li><b>%s:</b> %s</li>", name, phone));
        }
        output.append("</ol>");

        if (isMatchFound){
            System.out.println(output);
        }
        else {
            System.out.println("<p>No matches!</p>");
        }
    }
}