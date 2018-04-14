package DataRepresentation;

import java.util.Scanner;
import java.util.TreeMap;

public class P06OverlappingIntervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer n = Integer.parseInt(scan.nextLine());

        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            String[] interval = scan.nextLine().split(",");
            Integer start = Integer.parseInt(interval[0]);
            Integer end = Integer.parseInt(interval[1]);

            intervals.put(start, end);
        }

        for (int i = 0; i < intervals.size() - 1; i++) {

            Integer currentIntervalStart = (Integer)intervals.keySet().toArray()[i];
            Integer currentIntervalEnd = intervals.get(currentIntervalStart);
            Integer nextIntervalStart = (Integer) intervals.keySet().toArray()[i + 1];

            if (currentIntervalStart <= nextIntervalStart && nextIntervalStart <= currentIntervalEnd) {
                found = true;
                break;
            }
        }
        System.out.print(found);
    }
}