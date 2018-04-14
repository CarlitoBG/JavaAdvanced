package IntroToJava;

import java.util.Arrays;
import java.util.Scanner;

public class P13BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long blurAmount = Long.parseLong(scanner.nextLine());

        int[] matrixParams = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int matrixRows = matrixParams[0];
        int matrixCols = matrixParams[1];

        long[][] matrix = new long[matrixRows][matrixCols];
        for (int i = 0; i < matrixRows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        }

        int[] blurParams = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int blurRow = blurParams[0];
        int blurCol = blurParams[1];

        blurFilter(blurAmount, matrixRows, matrixCols, matrix, blurRow, blurCol );
    }

    private static void blurFilter(long blurAmount, int matrixRows, int matrixCols, long[][] matrix, int blurRow, int blurCol) {

        int startRow = Math.max(blurRow - 1, 0);                           //9         10 10 10
        int endRow = Math.min(blurRow + 1, matrixRows);                    //3 3       10 10 10
        int startCol = Math.max(blurCol - 1, 0);                           //1 1 1     10 10 10
        int endCol = Math.min(blurCol + 1, matrixCols);                    //1 1 1
                                                                           //1 1 1
        for (int row = 0; row < matrixRows; row++) {                       //1 1
            for (int col = 0; col < matrixCols; col++) {
                if (row >= startRow && row <= endRow && col >= startCol && col <= endCol) {
                    System.out.printf("%s ", matrix[row][col] + blurAmount);
                } else {
                    System.out.printf("%s ", matrix[row][col]);
                }
            }
            System.out.println();
        }
    }
}