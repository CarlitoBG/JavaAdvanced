package ObjectsClassesAndAPIs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P03BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int numOfElementsToPush = inputArray[0];
        int numOfElementsToPop = inputArray[1];
        int elementToCheck = inputArray[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numOfElementsToPush; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < numOfElementsToPop; i++) {
            queue.poll();
        }

        if (queue.contains(elementToCheck)){
            System.out.println(true);
        }else {
            if (queue.isEmpty()){
                System.out.println(queue.size());
            }else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}