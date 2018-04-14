package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        fillMatrix(scanner, matrix);

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row == col){
                    primaryDiagonalSum += matrix[row][col];
                }
                if (col == matrixSize - 1 - row){
                    secondaryDiagonalSum += matrix[row][col];
                }
            }
        }

        System.out.printf("%d", Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }
    }
}