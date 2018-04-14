package AsynchronousProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class P04Benchmarking {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int to = Integer.valueOf(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= to; i++) {
            numbers.add(i);
        }

        long start = System.nanoTime();

        ExecutorService es = Executors.newFixedThreadPool(4);

        Future[] results = new Future[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            Future<Boolean> future = es.submit(() -> isPrime(number));
            results[i] = future;
        }

        es.awaitTermination(100L, TimeUnit.MILLISECONDS);

        long total = System.nanoTime() - start;
        System.out.println("Execution time: " + total);
        es.shutdown();

        for (Future result : results) {
            System.out.println(result.get());
        }
    }

    private static boolean isPrime(Integer number) {
        if (number < 2){
            return false;
        }

        for (int divider = 2; divider <= Math.sqrt(number); divider++) {
            if (number % divider == 0){
                return false;
            }
        }

        return true;
    }
}