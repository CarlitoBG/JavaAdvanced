package StringProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P15ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<=^|[\\\\ /()])[a-zA-Z][a-zA-Z0-9_]{2,24}(?=$|[\\\\ /()])");
        Matcher matcher = pattern.matcher(line);

        List<String> usernames = new ArrayList<>();

        while (matcher.find()){
            usernames.add(matcher.group());
        }

        int maxSum = Integer.MIN_VALUE;
        String firstUsername = "";
        String secondUsername = "";

        for (int i = 0; i < usernames.size() - 1; i++) {
            int currentSum = usernames.get(i).length() + usernames.get(i + 1).length();

            if (currentSum > maxSum){
                maxSum = currentSum;
                firstUsername = usernames.get(i);
                secondUsername = usernames.get(i + 1);
            }
        }

        System.out.printf("%s\n%s", firstUsername, secondUsername);
    }
}