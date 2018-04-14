package StringProcessing;

import java.util.Scanner;

public class P03ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String upcaseStart = "<upcase>";
        String upcaseStop = "</upcase>";

        while (input.contains(upcaseStart)){
            int startIndex = input.indexOf(upcaseStart);
            int endIndex = input.indexOf(upcaseStop);

            String remainder = input.substring(startIndex + upcaseStart.length(), endIndex);
            String upRemainder = remainder.toUpperCase();
            input = input.replaceFirst(remainder, upRemainder);
            input = input.replaceFirst(upcaseStart, "");
            input = input.replaceFirst(upcaseStop, "");
        }

        System.out.println(input);
    }
}