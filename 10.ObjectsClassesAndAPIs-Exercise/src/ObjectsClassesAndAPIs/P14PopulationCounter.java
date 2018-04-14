package ObjectsClassesAndAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P14PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Map<String, LinkedHashMap<String, Long>> populationMap = new LinkedHashMap<>();

        while (!input.equals("report")){

            String[] inputParams = input.split("\\|");
            String city = inputParams[0];
            String country = inputParams[1];
            long population = Long.parseLong(inputParams[2]);

            if (!populationMap.containsKey(country)){
                populationMap.put(country, new LinkedHashMap<>());
            }
            populationMap.get(country).put(city, population);

            input = reader.readLine();
        }

        populationMap.entrySet().stream()
                .sorted((country1, country2) -> country2.getValue().values().stream().reduce(0L, Long::sum)
                        .compareTo(country1.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(country -> { System.out.printf("%s (total population: %d)%n", country.getKey(),
                        country.getValue().values().stream().reduce(0L, Long::sum));

                country.getValue().entrySet().stream()
                        .sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                        .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });

    }
}