package IntroToJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] commands = scanner.nextLine().split("\\s+");

        int numberOfElements = Integer.parseInt(commands[1]);
        int evenOrOddCommand = ("even".equals(commands[2])) ? 0 : 1;

        List<Integer> evenOddElements = new ArrayList<>();

        for (int element : elements) {
            if (Math.abs(element % 2) == evenOrOddCommand) {
                evenOddElements.add(element);
            }
        }

        evenOddElements.stream().limit(numberOfElements).forEach(element -> System.out.printf("%d ", element));
    }
}