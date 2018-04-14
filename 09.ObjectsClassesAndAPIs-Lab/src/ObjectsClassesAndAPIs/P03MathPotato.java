package ObjectsClassesAndAPIs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P03MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] children = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(children));

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            }else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number) {
        if (number < 2){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}