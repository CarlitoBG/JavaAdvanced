package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public class P06FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isNumber = num -> num.matches("-?\\d+");

        Optional<Integer> sumOfInts = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(isNumber)
                .map(Integer::valueOf)
                .reduce((n1, n2) -> n1 + n2);

        if (sumOfInts.isPresent()){
            System.out.printf("%d", sumOfInts.get());
        }else System.out.println("No match");
    }
}