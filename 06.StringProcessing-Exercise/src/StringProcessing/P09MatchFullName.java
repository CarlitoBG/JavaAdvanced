package StringProcessing;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P09MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        while (!input.equals("end")){

            if (Pattern.matches(regex, input)){
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}