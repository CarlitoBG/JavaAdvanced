package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int matrixRow = matrixDimensions[0];
        int matrixCol = matrixDimensions[1];

        int[][]matrix = new int[matrixRow][matrixCol];

        readMatrix(scanner, matrix);

        int bestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > bestSum){
                    bestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }

        printSubMatrixAndSum(matrix, bestSum, resultRow, resultCol);
    }

    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
    }

    private static void printSubMatrixAndSum(int[][] matrix, int bestSum, int resultRow, int resultCol) {
        for (int i = resultRow; i <= resultRow + 1 ; i++) {
            for (int j = resultCol; j < resultCol + 1; j++) {
                System.out.println(matrix[i][j] + " " + matrix[i][j + 1]);
            }
        }

        System.out.println(bestSum);
    }
}