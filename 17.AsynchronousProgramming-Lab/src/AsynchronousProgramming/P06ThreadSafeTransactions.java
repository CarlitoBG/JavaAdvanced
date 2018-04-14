package AsynchronousProgramming;

public class P06ThreadSafeTransactions {
    public static void main(String[] args) throws InterruptedException {
        final int transactions = 100;
        final int operationsPerTransactions = 100;

        Account account = new Account();
        Runnable task = () -> {
            for (int i = 0; i < operationsPerTransactions; i++) {
                account.deposit(1);
                Thread.yield();
            }
        };

        Thread[] threads = new Thread[transactions];
        for (int i = 0; i < transactions; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(account.balance);
    }

    private static class Account{
        private int balance;

        synchronized void deposit(int amount){
            balance = this.balance + amount;
        }
    }
}