package DataRepresentation;

import java.util.Scanner;

public class P04RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        long factorial = calcFactorial(number);
        System.out.println(factorial);
    }

    private static long calcFactorial(int number) {
        if (number == 0){
            return 1;
        }

        return number * calcFactorial(number - 1);
    }
}