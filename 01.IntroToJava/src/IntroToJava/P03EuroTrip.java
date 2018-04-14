package IntroToJava;

import java.math.BigDecimal;
import java.util.Scanner;

public class P03EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantity = scanner.nextDouble();

        final double pricePerKiloInLevs = 1.20;
        final BigDecimal exchangeRate = new BigDecimal("4210500000000");

        BigDecimal priceInLevs = new BigDecimal(quantity * pricePerKiloInLevs);
        BigDecimal priceInMarks = exchangeRate.multiply(priceInLevs);

        System.out.printf("%.2f marks", priceInMarks);
    }
}