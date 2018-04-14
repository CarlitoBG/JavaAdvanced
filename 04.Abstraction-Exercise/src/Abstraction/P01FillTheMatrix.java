package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixParams = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(matrixParams[0]);
        String pattern = matrixParams[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        if (pattern.equals("A")) {
            applyPatternA(matrix);
        }else if (pattern.equals("B")){
            applyPatternB(matrix);
        }

        printMatrix(matrix);
    }

    private static void applyPatternA(int[][] matrix) {
        int number = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = number++;
            }
        }
    }

    private static void applyPatternB(int[][] matrix) {
        int number = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = number++;
                }
            }else{
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = number++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", ""));
        }
    }
}