package StringProcessing;

import java.util.Scanner;

public class P02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder num1 = new StringBuilder(scanner.nextLine().replaceAll("^0+", ""));
        StringBuilder num2 = new StringBuilder(scanner.nextLine().replaceAll("^0+", ""));

        StringBuilder result = new StringBuilder();

        if (num1.length() < num2.length()){
            int difference = num2.length() - num1.length();
            while (difference > 0){
                num1.insert(0, "0");
                difference--;
            }
        }

        if (num1.length() > num2.length()){
            int difference = num1.length() - num2.length();
            while (difference > 0){
                num2.insert(0, "0");
                difference--;
            }
        }

        int leadingDigit = 0;
        for (int i = num1.length() - 1; i >=0 ; i--) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            int remainder = (digit1 + digit2 + leadingDigit) % 10;
            result.append(remainder);
            leadingDigit = (digit1 + digit2 + leadingDigit) / 10;
        }

        if (leadingDigit > 0){
            result.append(leadingDigit);
        }

        result.reverse();
        System.out.println(result);
    }
}