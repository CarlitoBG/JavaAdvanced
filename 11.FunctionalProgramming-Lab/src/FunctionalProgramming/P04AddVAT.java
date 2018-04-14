package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class P04AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        Double[] numbers = Arrays.stream(scan.readLine().split(", ")).map(Double::parseDouble).toArray(Double[]::new);

        UnaryOperator<Double> addVAT = num -> num * 1.2;

        System.out.println("Prices with VAT:");
        for (Double num : numbers) {
            System.out.println(String.format("%1$.2f", addVAT.apply(num)).replace(".", ","));
        }
    }
}