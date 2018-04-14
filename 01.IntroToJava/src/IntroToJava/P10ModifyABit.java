package IntroToJava;

import java.util.Scanner;

public class P10ModifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int position = scanner.nextInt();
        int value = scanner.nextInt();

        int mask = (1 << position);
        int result;

        if (value == 0) {
            result = number & ~mask;
        }
        else {
            result = number | mask;
        }

        System.out.println(result);
    }
}