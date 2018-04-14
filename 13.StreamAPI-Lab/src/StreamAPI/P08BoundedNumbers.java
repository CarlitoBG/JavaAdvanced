package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P08BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> bounds = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .filter(n -> Collections.min(bounds) <= n && n <= Collections.max(bounds))
                .forEach(n -> System.out.printf("%d ", n));
    }
}