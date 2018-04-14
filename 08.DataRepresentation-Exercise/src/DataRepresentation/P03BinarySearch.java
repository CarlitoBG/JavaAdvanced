package DataRepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03BinarySearch {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(reader.readLine());

        System.out.println(binarySearch(numbers, key, 0, numbers.length - 1));
    }

    private static int binarySearch(int[] numbers, int key, int startIndex, int endIndex) {

        if (startIndex <= endIndex){

            int mid = (startIndex + endIndex) / 2;

            if (key < numbers[mid]){
                return binarySearch(numbers, key, startIndex, mid);
            }else if (key > numbers[mid]){
                return binarySearch(numbers, key, mid + 1, endIndex);
            }else {
                return mid;
            }
        }
        return -1;
    }
}