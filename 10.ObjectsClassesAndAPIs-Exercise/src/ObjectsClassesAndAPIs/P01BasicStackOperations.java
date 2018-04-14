package ObjectsClassesAndAPIs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P01BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int numOfElementsToPush = inputArray[0];
        int numOfElementsToPop = inputArray[1];
        int elementToCheck = inputArray[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numOfElementsToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < numOfElementsToPop; i++) {
            stack.pop();
        }

        if (stack.contains(elementToCheck)){
            System.out.println(true);
        }else {
            if (stack.isEmpty()){
                System.out.println(stack.size());
            }else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}