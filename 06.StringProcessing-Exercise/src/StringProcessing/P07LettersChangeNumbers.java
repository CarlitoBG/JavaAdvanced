package StringProcessing;

import java.util.Scanner;

public class P07LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String string : line) {
            char firstDigit = string.charAt(0);
            char lastDigit = string.charAt(string.length() - 1);
            double num = Double.parseDouble(string.substring(1, string.length() - 1));

            if (Character.toString(firstDigit).equals(Character.toString(firstDigit).toLowerCase())){
                num *= firstDigit - 96;
            }else {
                num /= firstDigit - 64;
            }

            if (Character.toString(lastDigit).equals(Character.toString(lastDigit).toLowerCase())){
                num += lastDigit - 96;
            }else {
                num -= lastDigit - 64;
            }

            sum += num;
        }

        System.out.printf("%.2f", sum);
    }
}