package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P01StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> students = new HashMap<>();

        while (true){
            String line = reader.readLine();
            if ("END".equals(line)){
                break;
            }

            List<String> tokens = Arrays.stream(line.split("\\s+"))
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            if (tokens.isEmpty()){
                return;
            }

            String studentName = tokens.get(0) + " " + tokens.get(1);
            String group = tokens.get(2);
            students.put(studentName, group);
        }

        students.entrySet().stream()
                .filter(s -> "2".equals(s.getValue()))
                .sorted(Comparator.comparing(s2 -> s2.getKey().substring(0, s2.getKey().indexOf(" "))))
                .forEach(s -> System.out.println(s.getKey()));
        System.out.println();
    }
}