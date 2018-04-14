package ObjectsClassesAndAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P12AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String resource = reader.readLine();

        Map<String, Integer> minerTask = new LinkedHashMap<>();

        while (!resource.equals("stop")){

            int quantity = Integer.parseInt(reader.readLine());

            if (!minerTask.containsKey(resource)){
                minerTask.put(resource, 0);
            }
            minerTask.put(resource, minerTask.get(resource) + quantity);

            resource = reader.readLine();
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : minerTask.entrySet()) {
            System.out.printf("%s -> %d\n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }
}