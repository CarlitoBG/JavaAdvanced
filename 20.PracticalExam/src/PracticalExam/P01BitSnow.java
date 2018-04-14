package PracticalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(",\\s+");

        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        boolean isChanged = true;

        while (isChanged){

            isChanged = false;

            for (int i = 0; i < numbers.length - 1; i++) {

                int newUpper = numbers[i] & numbers[i + 1];
                int newLower = numbers[i] | numbers[i + 1];

                if (numbers[i + 1] != newLower){
                    isChanged = true;
                    numbers[i] = newUpper;
                    numbers[i + 1] = newLower;
                }
            }
        }

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
    }
}