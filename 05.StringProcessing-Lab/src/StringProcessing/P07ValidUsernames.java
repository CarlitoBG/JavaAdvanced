package StringProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> result = new ArrayList<>();

        while (!input.equals("END")) {

            Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                result.add("valid");
            }
            else {
                result.add("invalid");
            }

            input = scanner.nextLine();
        }

        if (result.contains("valid")) {
            result.forEach(System.out::println);
        }
    }
}