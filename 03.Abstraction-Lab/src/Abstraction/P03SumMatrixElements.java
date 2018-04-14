package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int matrixRow = matrixDimensions[0];
        int matrixCol = matrixDimensions[1];

        int[][] matrix = new int[matrixRow][matrixCol];

        int sumOfAllElements = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
                sumOfAllElements += matrix[row][col];
            }
        }

        System.out.printf("%d\n%d\n%d\n", matrixRow, matrixCol, sumOfAllElements);
    }
}