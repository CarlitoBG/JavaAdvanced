package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P07MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> cities = new HashMap<>();

        List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));
        for (String token : tokens) {
            String[] tokenParams = token.split(":");
            String city = tokenParams[0];
            int districtPopulation = Integer.valueOf(tokenParams[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(districtPopulation);
        }

        int bound = Integer.valueOf(reader.readLine());

        cities.entrySet().stream()
                .filter(filterByPopulationPredicate(bound))
                .sorted(sortByDescendingPopulation())
                .forEach(printMapEntry());
    }

    private static Predicate<Map.Entry<String, List<Integer>>> filterByPopulationPredicate(int bound) {
        return kv -> kv.getValue().stream()
                .mapToInt(Integer::valueOf)
                .sum() >= bound;
    }

    private static Comparator<Map.Entry<String, List<Integer>>> sortByDescendingPopulation() {
        return (kv1, kv2) -> Integer.compare(
                kv2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                kv1.getValue().stream().mapToInt(Integer::valueOf).sum());
    }

    private static Consumer<Map.Entry<String, List<Integer>>> printMapEntry() {
        return kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(dp -> System.out.print(dp + " "));
            System.out.println();
        };
    }
}