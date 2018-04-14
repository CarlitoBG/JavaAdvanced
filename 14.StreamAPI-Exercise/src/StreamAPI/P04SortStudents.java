package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P04SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();

        while (true){
            String inputLine = reader.readLine();
            if ("END".equals(inputLine)){
                break;
            }

            if (!inputLine.isEmpty()){
                students.add(inputLine);
            }
        }

        students.stream().sorted((s1, s2) -> {
            if (s1.split("\\s+")[1].compareTo(s2.split("\\s+")[1]) == 0){
                return s2.split("\\s+")[0].compareTo(s1.split("\\s+")[0]);
            }else {
                return s1.split("\\s+")[1].compareTo(s2.split("\\s+")[1]);
            }
        }).forEach(System.out::println);
    }
}