package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        Function<Integer[], Integer> findMinFunction =
                nums -> Arrays.stream(nums).reduce(Integer.MAX_VALUE, Integer::min);

        System.out.println(findMinFunction.apply(numbers));
    }
}