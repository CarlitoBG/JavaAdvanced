package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P03StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> studentsByAge = new ArrayList<>();

        while (true){
            String inputLine = reader.readLine();
            if ("END".equals(inputLine)){
                break;
            }

            if (!inputLine.isEmpty()){
                studentsByAge.add(inputLine);
            }
        }

        studentsByAge.stream()
                .filter(s -> s != null && !s.isEmpty())
                .filter(s -> (Integer.valueOf(s.split("\\s+")[2]) >= 18)
                        && (Integer.valueOf(s.split("\\s+")[2]) <= 24))
                .forEach(System.out::println);
    }
}