package IntroToJava;

import java.util.Scanner;

public class P09ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int index = scanner.nextInt();

        int mask = number >> index;
        int bit = mask & 1;

        System.out.println(bit);
    }
}