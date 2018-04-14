package DataRepresentation;

import java.util.Arrays;
import java.util.Scanner;

public class P01Sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        selectionSort(numbers);
        bubbleSort(numbers);

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }

    private static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {

            int min = i;
            for (int current = i + 1; current < numbers.length; current++) {
                if (numbers[current] < numbers[min]){
                    min = current;
                }
            }

            int temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
        }
    }

    private static void bubbleSort(int[] numbers) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]){

                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;

                    swapped = true;
                }
            }
        }while (swapped);
    }
}