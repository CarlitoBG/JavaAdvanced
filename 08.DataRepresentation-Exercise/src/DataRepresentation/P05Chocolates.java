package DataRepresentation;

import java.util.Arrays;
import java.util.Scanner;

public class P05Chocolates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPackets = Integer.parseInt(scanner.nextLine());
        int[] packets = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Arrays.sort(packets);

        int minDifference = packets[packets.length - 1] - packets[0];

        for (int i = 0; i <= numberOfPackets - numberOfStudents; i++) {
            int currentDifference = packets[i + numberOfStudents - 1] - packets[i];
            if (currentDifference < minDifference){
                minDifference = currentDifference;
            }
        }

        System.out.println(String.format("Min Difference is %d.", minDifference));
    }
}