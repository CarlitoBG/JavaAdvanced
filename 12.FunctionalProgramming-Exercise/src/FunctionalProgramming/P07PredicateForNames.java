package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class P07PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer length = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        Predicate<String> predicate = name -> name.length() <= length;

        for (String name : names) {
            if (predicate.test(name)) {
                System.out.println(name);
            }
        }
    }
}