package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P10GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>();

        while (true) {
            String line = reader.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            Integer group = Integer.valueOf(tokens[2]);

            Person person = new Person(name, group);
            personList.add(person);
        }

        personList.stream()
                .collect(Collectors.groupingBy(Person::getGroup))
                .forEach((key, value) -> {
                    System.out.printf("%d - ", key);
                    System.out.println(value
                            .stream()
                            .map(Person::getName)
                            .collect(Collectors.joining(", ")));
                });
    }
}