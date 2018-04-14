package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParams = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixParams[0];
        int cols = matrixParams[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix);

        int maxSum = Integer.MIN_VALUE;
        int startingRow = 0;
        int startingCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum){
                    maxSum = currentSum;
                    startingRow = row;
                    startingCol = col;
                }
            }
        }

        printSumAndMatrix(matrix, maxSum, startingRow, startingCol);
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }

    private static void printSumAndMatrix(int[][] matrix, int maxSum, int startingRow, int startingCol) {

        System.out.println("Sum = " + maxSum);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.printf(matrix[startingRow + row][startingCol + col] + " ");
            }
            System.out.println();
        }
    }
}