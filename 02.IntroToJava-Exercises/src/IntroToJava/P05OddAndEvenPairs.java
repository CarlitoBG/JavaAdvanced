package IntroToJava;

import java.util.Arrays;
import java.util.Scanner;

public class P05OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (numbers.length % 2 == 1){
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i < numbers.length; i += 2) {
            if (numbers[i] % 2 == 0 && numbers[i + 1] % 2 == 0){
                System.out.printf("%d, %d -> both are even\n", numbers[i], numbers[i + 1]);
            }else if (numbers[i] % 2 != 0 && numbers[i + 1] % 2 != 0){
                System.out.printf("%d, %d -> both are odd\n", numbers[i], numbers[i + 1]);
            }else {
                System.out.printf("%d, %d -> different\n", numbers[i], numbers[i + 1]);
            }
        }
    }
}