package DataRepresentation;

import java.util.Arrays;
import java.util.Scanner;

public class P02NestedLoopsToRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLoops = Integer.parseInt(scanner.nextLine());

        int[] loops = new int[numberOfLoops];

        simulateLoops(0, numberOfLoops, loops);
    }

    private static void simulateLoops(int currentLoop, int numberOfLoops, int[] loops) {
        if (currentLoop == numberOfLoops) {
            System.out.println(Arrays.toString(loops).replaceAll("[\\]\\[,]", ""));
            return;
        }

        for (int i = 1; i <= numberOfLoops; i++) {
            loops[currentLoop] = i;
            simulateLoops(currentLoop + 1, numberOfLoops, loops);
        }
    }
}