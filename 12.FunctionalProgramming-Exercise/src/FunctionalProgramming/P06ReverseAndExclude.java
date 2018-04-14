package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class P06ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer n = Integer.parseInt(reader.readLine());

        Predicate<Integer> exclude = number -> number % n == 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (!exclude.test(numbers[i])){
                System.out.printf("%d ", numbers[i]);
            }
        }
    }
}