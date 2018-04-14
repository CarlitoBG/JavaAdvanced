package IntroToJava;

import java.util.Scanner;

public class P03FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.printf("|%-10s", Integer.toHexString(a).toUpperCase());
        System.out.printf("|%010d", Integer.parseInt(Integer.toBinaryString(a)));
        System.out.printf("|%10.2f", b);
        System.out.printf("|%-10.3f|", c);
    }
}