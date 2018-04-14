package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class P13InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Map<String, Predicate<Integer>> commands = new HashMap<>();

        while (true) {
            String[] input = reader.readLine().split(";");
            if ("Forge".equals(input[0])) {
                break;
            }

            Predicate<Integer> predicate = makePredicate(input, numbers);

            if ("Exclude".equals(input[0])) {
                commands.put(input[1] + input[2], predicate);
            }else {
                commands.remove(input[1] + input[2]);
            }
        }

        for (int i = 0; i < numbers.length; i++) {

            boolean forRemove = false;
            for (Map.Entry<String, Predicate<Integer>> stringPredicateEntry : commands.entrySet()) {
                if (stringPredicateEntry.getValue().test(i)){
                    forRemove = true;
                    break;
                }
            }

            if (!forRemove){
                System.out.print(numbers[i] + " ");
            }
        }
    }

    private static Predicate<Integer> makePredicate(String[] input, int[] numbers) {
        switch (input[1]) {
            case "Sum Left":
                return index -> (index > 0 ? numbers[index - 1] : 0) + numbers[index] == Integer.valueOf(input[2]);
            case "Sum Right":
                return index -> numbers[index] + (index < numbers.length - 1 ? numbers[index + 1] : 0) == Integer.valueOf(input[2]);
            default:
                return index -> ((index > 0 ? numbers[index - 1] : 0) + numbers[index] +
                        (index < numbers.length - 1 ? numbers[index + 1] : 0)) == Integer.valueOf(input[2]);
        }
    }
}