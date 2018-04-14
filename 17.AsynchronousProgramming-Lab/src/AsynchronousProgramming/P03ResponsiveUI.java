package AsynchronousProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03ResponsiveUI {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int to = Integer.valueOf(scanner.nextLine());

        Runnable task = () -> printPrimes(to);
        Thread thread = new Thread(task);
        thread.start();

        while (true){
            String command = scanner.nextLine();

            if ("stop".equals(command)){
                thread.interrupt();
                break;
            }else {
                System.out.println("unknown command");
            }
        }

        thread.join();
    }

    private static void printPrimes(int to) {
        List<Integer> primes = new ArrayList<>();

        for (int number = 0; number < to; number++) {
            if (isPrime(number)){
                primes.add(number);
            }

            if (Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted...");
                break;
            }
        }

        System.out.println(primes.stream()
                .limit(10)
                .collect(Collectors.toList()) + "...");
        System.out.printf("%d primes calculated.", primes.size());
    }

    private static boolean isPrime(int number) {
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