package DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03RecursiveArraySum {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = sum(numbers, 0);
        System.out.println(sum);
    }

    private static int sum(int[] numbers, int index) {
        if (index == numbers.length - 1){
            return numbers[index];
        }

        return numbers[index] + sum(numbers, index + 1);
    }
}