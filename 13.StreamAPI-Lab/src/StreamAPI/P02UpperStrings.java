package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P02UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> strings = Arrays.asList(reader.readLine().split("\\s+"));

        strings.stream().map(String::toUpperCase).forEach(s -> System.out.printf("%s ", s));
    }
}