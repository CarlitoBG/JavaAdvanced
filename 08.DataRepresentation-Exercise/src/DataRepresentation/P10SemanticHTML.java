package DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10SemanticHTML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = reader.readLine();

        List<String> lines = new ArrayList<>();

        while (!inputLine.equals("END")) {
            lines.add(inputLine);

            inputLine = reader.readLine();
        }

        Pattern openingTag = Pattern.compile("(?<start>.*)(?<line>(?<openTag><div(?=\\s))(.*)" +
                "(?<remove>(?<=\\s)(?:id|class)\\s*=\\s*\"(?<tag>[a-z]+)\")(.*>))");
        Pattern closingTag = Pattern.compile("(?<start>.*)</div>\\s+<!--\\s*(?<tag>[a-z]+)\\s*-->");

        for (String line : lines) {
            Matcher openMatch = openingTag.matcher(line);
            if (openMatch.matches()) {
                line = openMatch.group()
                        .replace(openMatch.group("openTag"), "<" + openMatch.group("tag"))
                        .replace(openMatch.group("remove"), "")
                        .replaceAll("\\s+", " ")
                        .replaceAll("\\s+>", ">");
            }

            Matcher closeMatch = closingTag.matcher(line);
            if (closeMatch.matches()) {
                line = closeMatch.group("start") + "</" + closeMatch.group("tag") + ">";
            }

            System.out.println(line);
        }
    }
}