package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P07ExcellentStudents {
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

            String studentName = tokens.get(0) + " " + tokens.get(1);
            List<Integer> grades = tokens.subList(2, tokens.size()).stream()
                    .map(Integer::valueOf).collect(Collectors.toList());
            students.put(studentName, grades);
        }

        students.entrySet().stream()
                .filter(s -> s.getValue().stream().anyMatch(m -> m == 6))
                .forEach(s -> System.out.println(s.getKey()));
    }
}