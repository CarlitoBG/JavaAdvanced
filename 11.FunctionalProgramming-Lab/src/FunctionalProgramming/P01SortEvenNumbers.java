package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] input = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        List<Integer> numList = new ArrayList<>(Arrays.asList(input));

        numList.removeIf(n -> n % 2 != 0);
        System.out.println(numList.toString().replaceAll("[\\[\\]]", ""));
        numList.sort(Integer::compareTo);
        System.out.println(numList.toString().replaceAll("[\\[\\]]", ""));
    }
}