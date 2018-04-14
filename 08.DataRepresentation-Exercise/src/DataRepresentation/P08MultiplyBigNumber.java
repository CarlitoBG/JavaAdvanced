package DataRepresentation;

import java.util.Scanner;

public class P08MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstNum = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int secondNum = Integer.parseInt(scanner.nextLine());

        StringBuilder result = new StringBuilder();

        int leadingDigit = 0;
        for (int i = firstNum.length() - 1; i >= 0; i--) {
            int lastDigit = Integer.parseInt(String.valueOf(firstNum.charAt(i)));
            int product = lastDigit * secondNum + leadingDigit;

            result.insert(0, product % 10);
            leadingDigit = product / 10;
        }

        if (leadingDigit > 0){
            result.insert(0, leadingDigit);
        }

        System.out.println(result.toString().replaceFirst("^0+(?!$)", ""));
    }
}