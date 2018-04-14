package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class P10ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] numbers =
                Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<Predicate<Integer>> predicates = new ArrayList<>();

        for (int number : numbers) {
            Predicate<Integer> predicate = x -> x % number == 0;
            predicates.add(predicate);
        }

        List<Integer> result = new ArrayList<>();

        for (int num = 1; num <= n; num++) {
            boolean divisible = false;
            for (Predicate<Integer> predicate : predicates) {
                if (predicate.test(num)){
                    divisible = true;
                }else {
                    divisible = false;
                    break;
                }
            }

            if (divisible){
                result.add(num);
            }
        }

        for (Integer number : result) {
            System.out.print(number + " ");
        }
    }
}