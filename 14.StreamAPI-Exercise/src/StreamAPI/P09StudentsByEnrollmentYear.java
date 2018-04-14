package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P09StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        while (true) {
            String line = reader.readLine();
            if ("END".equals(line)) {
                break;
            }

            List<String> tokens = Arrays.stream(line.split("\\s+"))
                    .filter(s -> (s != null && !s.isEmpty())).collect(Collectors.toList());
            if (tokens.isEmpty()) {
                return;
            }

            String facultyNumber = tokens.get(0);
            List<Integer> grades = tokens.subList(1, tokens.size()).stream()
                    .map(Integer::valueOf).collect(Collectors.toList());
            students.put(facultyNumber, grades);
        }

        students.entrySet().stream()
                .filter(s -> s.getKey().endsWith("14") || s.getKey().endsWith("15"))
                .forEach(s -> System.out.println(Arrays.toString(s.getValue().toArray())
                        .replaceAll("[\\[\\],]", "")));
    }
}