package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P08FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers =
                Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        Function<Integer[], Integer> findSmallestElement = nums ->
                Arrays.stream(nums).reduce(Integer.MAX_VALUE, Integer::min);

        int minValue = findSmallestElement.apply(numbers);

        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
           if (numbers[i] == minValue){
               index = i;
           }
        }

        System.out.println(index);
    }
}