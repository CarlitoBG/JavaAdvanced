package DataRepresentation;

import java.util.Arrays;
import java.util.Scanner;

public class P07FindTheMissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);

        int missingNumber = 1;

        for (int i = 0; i < n - 1; i++) {
            if (numbers[i] == i + 1){
                missingNumber++;
                continue;
            }
            break;
        }

        System.out.println(missingNumber);
    }
}