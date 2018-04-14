package DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02Searching {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(reader.readLine());

        System.out.println(binarySearch(numbers, target));
    }

    private static int binarySearch(int[] numbers, int target) {

        int startIndex = 0;
        int endIndex = numbers.length -1;

        while (startIndex <= endIndex){

            int middleIndex = (startIndex + endIndex) / 2;

            if (numbers[middleIndex] == target){
                return middleIndex;
            } else if (numbers[middleIndex] < target){
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }

        return -1;
    }
}