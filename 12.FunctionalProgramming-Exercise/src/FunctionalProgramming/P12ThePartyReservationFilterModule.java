package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class P12ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> guests = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));
        boolean[] isAddFilterArray = new boolean[guests.size()];

        while (true) {
            String[] commands = reader.readLine().split(";");
            if ("Print".equals(commands[0])) {
                break;
            }

            String command = commands[0];
            String filterType = commands[1];
            String filterParam = commands[2];

            Predicate<String> matchFilter = matchFilterPredicate(filterType, filterParam);
            if (matchFilter == null) {
                continue;
            }

            boolean isAddFilter = "Add filter".equals(command);

            for (int i = 0; i < guests.size(); i++) {
                if (matchFilter.test(guests.get(i))) {
                    isAddFilterArray[i] = isAddFilter;
                }
            }
        }

        for (int i = 0; i < guests.size(); i++) {
            if (!isAddFilterArray[i]) {
                System.out.printf("%s ", guests.get(i));
            }
        }
    }

    private static Predicate<String> matchFilterPredicate(String filterType, String filterParam) {
        switch (filterType) {
            case "Starts with":
                return name -> name.startsWith(filterParam);
            case "Ends with":
                return name -> name.endsWith(filterParam);
            case "Length":
                return name -> name.length() == Integer.parseInt(filterParam);
            case "Contains":
                return name -> name.contains(filterParam);
            default:
                return null;
        }
    }
}