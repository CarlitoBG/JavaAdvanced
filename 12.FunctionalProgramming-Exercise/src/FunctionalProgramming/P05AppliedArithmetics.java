package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P05AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        while (true) {
            String command = reader.readLine();
            if ("end".equals(command)) {
                break;
            }

            if ("print".equals(command)) {
                System.out.println(Arrays.toString(numbers).replaceAll("[,\\]\\[]", ""));
            } else {
                Function<Integer, Integer> applyArithmetic = calculate(command);
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = applyArithmetic.apply(numbers[i]);
                }
            }
        }
    }

    private static Function<Integer, Integer> calculate (String command) {
        switch (command) {
            case "add":
                return number -> number + 1;
            case "multiply":
                return number -> number * 2;
            case "subtract":
            default:
                return number -> number - 1;
        }
    }
}