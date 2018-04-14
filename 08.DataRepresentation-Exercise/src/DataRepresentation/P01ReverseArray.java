package DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        reverseArray(numbers, 0, numbers.length - 1);

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }

    private static void reverseArray(int[] numbers, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            swap(numbers, startIndex, endIndex);
            reverseArray(numbers, startIndex + 1, endIndex - 1);
        }
    }

    private static void swap(int[] numbers, int startIndex, int endIndex) {
        int temp = numbers[startIndex];
        numbers[startIndex] = numbers[endIndex];
        numbers[endIndex] = temp;
    }
}