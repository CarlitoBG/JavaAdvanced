package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P06FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();

        while (true){
            String input = reader.readLine();
            if ("END".equals(input)){
                break;
            }

            if (!input.isEmpty()){
                students.add(input);
            }
        }

        students.stream()
                .filter(s -> s != null && !s.isEmpty())
                .filter(s -> s.split("\\s+")[2].startsWith("02") || s.split("\\s+")[2].startsWith("+3592"))
                .forEach(s -> System.out.println(s.split("\\s+")[0] + " " + s.split("\\s+")[1]));
    }
}