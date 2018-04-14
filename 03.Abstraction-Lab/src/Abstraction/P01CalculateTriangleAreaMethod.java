package Abstraction;

import java.util.Scanner;

public class P01CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double area = calcTriangleArea(base, height);
        System.out.printf("Area = %.2f", area);
    }

    private static double calcTriangleArea(double base, double height) {
        return (base * height) / 2;
    }
}