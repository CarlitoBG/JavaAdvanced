package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class P11PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> people = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        while (true) {
            String[] command = reader.readLine().split("\\s+");
            if ("Party!".equals(command[0])) {
                break;
            }

            String action = command[0];
            String criteria = command[1];
            String param = command[2];

            Predicate<String> matchCriteria = matchCriteriaPredicate(criteria, param);
            if (matchCriteria == null){
                continue;
            }

            if ("Remove".equals(action)) {
                people.removeIf(matchCriteria);
            } else if ("Double".equals(action)) {
                for (int i = 0; i < people.size(); i++) {
                    if (matchCriteria.test(people.get(i))){
                        people.add(i, people.get(i));
                        i++;
                    }
                }
            }
        }

        if (people.size() > 0) {
            System.out.printf("%s are going to the party!", people.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static Predicate<String> matchCriteriaPredicate(String criteria, String param) {
        switch (criteria) {
            case "StartsWith":
                return name -> name.startsWith(param);
            case "EndsWith":
                return name -> name.endsWith(param);
            case "Length":
                return name -> name.length() == Integer.parseInt(param);
            default:
                return null;
        }
    }
}