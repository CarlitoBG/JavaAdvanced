package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = reader.readLine().split(", ");
            String name = inputLine[0];
            Integer age = Integer.parseInt(inputLine[1]);

            people.put(name, age);
        }

        String condition = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> tester = createTester(condition, ageLimit);

        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        printFilteredStudents(people, tester, printer);

    }

    private static Predicate<Integer> createTester(String condition, Integer ageLimit) {
        switch (condition) {
            case "younger":
                return x -> x <= ageLimit;
            case "older":
                return x -> x >= ageLimit;
            default:
                return null;
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        switch (format) {
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            case "name":
                return person -> System.out.printf("%s", person.getKey());
            case "age":
                return person -> System.out.printf("%d%n", person.getValue());
            default:
                return null;
        }
    }

    private static void printFilteredStudents(
            LinkedHashMap<String, Integer> people, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))){
                printer.accept(person);
            }
        }
    }
}