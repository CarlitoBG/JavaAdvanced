package ObjectsClassesAndAPIs;

import java.util.*;

public class P02MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (commands[0] == 1){
                stack.push(commands[1]);
            }else if(commands[0] == 2){
                stack.pop();
            }else {
                System.out.println(Collections.max(stack));
            }
        }
    }
}