package ObjectsClassesAndAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P09TheStockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfStockPrices = Integer.parseInt(reader.readLine());

        int[] stockSpan = new int[numberOfStockPrices];

        for (int i = 0; i < numberOfStockPrices; i++) {
            int price = Integer.parseInt(reader.readLine());
            stockSpan[i] = price;
        }

        Deque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);

        StringBuilder days = new StringBuilder();
        days.append(1).append("\n");

        for (int i = 1; i < stockSpan.length; i++) {
            while (!indexes.isEmpty() && stockSpan[indexes.peek()] <= stockSpan[i]) {
                indexes.pop();
            }

            if (!indexes.isEmpty()) {
                days.append(i - indexes.peek()).append("\n");
            } else {
                days.append(i + 1).append("\n");
            }
            indexes.push(i);
        }

        System.out.println(days);
    }
}