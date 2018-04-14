package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P04TwoXTwoSquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParams = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixParams[0];
        int cols = matrixParams[1];

        char[][] matrix = new char[rows][cols];

        fillMatrix(scanner, matrix);

        int squaresNum = getSquaresNum(matrix);

        System.out.println(squaresNum);
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static int getSquaresNum(char[][] matrix) {

        int squaresNum = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                if (matrix[row][col] == matrix[row][col + 1] && matrix[row][col] == matrix[row + 1][col]
                        && matrix[row][col] == matrix[row + 1][col + 1]){
                    squaresNum++;
                }
            }
        }
        return squaresNum;
    }
}