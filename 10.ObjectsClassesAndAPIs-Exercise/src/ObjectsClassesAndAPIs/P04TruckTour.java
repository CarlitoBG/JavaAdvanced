package ObjectsClassesAndAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P04TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            queue.offer(input);
        }

        int index = -1;
        for (int i = 0; i < n; i++) {
            boolean success = true;
            int fuel = 0;

            for (int[] currentPump : queue) {
                fuel += currentPump[0];
                int distance = currentPump[1];

                if (fuel < distance){
                    success = false;
                    break;
                }
                fuel -= distance;
            }

            if (success){
                index = i;
                break;
            }
            queue.offer(queue.poll());
        }

        System.out.println(index);
    }
}