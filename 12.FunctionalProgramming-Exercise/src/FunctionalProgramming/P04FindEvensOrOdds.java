package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class P04FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        String command = reader.readLine();

        printNumbers(numbers[0], numbers[1], evenOrOddPredicate(command));
    }

    private static void printNumbers(Integer lowerBound, Integer upperBound, Predicate<Integer> evenOrOddPredicate) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (evenOrOddPredicate.test(i)){
                System.out.printf("%d ", i);
            }
        }
    }

    private static Predicate<Integer> evenOrOddPredicate(String command) {
        switch (command) {
            case "even":
                return number -> number % 2 == 0;
            case "odd":
            default:
                return number -> number % 2 != 0;
        }
    }
}