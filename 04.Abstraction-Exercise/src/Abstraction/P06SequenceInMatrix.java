package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P06SequenceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParams = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixParams[0];
        int cols = matrixParams[1];

        String[][] matrix = new String[rows][cols];

        fillMatrix(scanner, matrix);

        int maxSequence = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                int currentRow = row;
                int currentCol = col;
                int currentSequence = 1;
                String currentElement = matrix[currentRow][currentCol];

                while (currentCol < cols - 1 && currentElement.equals(matrix[currentRow][currentCol + 1])){ //LINE

                    currentSequence++;

                    if (currentSequence > maxSequence) {
                        maxSequence = currentSequence;
                        maxRow = currentRow;
                        maxCol = currentCol;
                    }
                    currentCol++;
                }

                currentRow = row;
                currentCol = col;
                currentSequence = 1;

                while (currentRow < rows - 1 && currentElement.equals(matrix[currentRow + 1][currentCol])){ //COLUMN

                    currentSequence++;

                    if (currentSequence >= maxSequence) {
                        maxSequence = currentSequence;
                        maxRow = currentRow;
                        maxCol = currentCol;
                    }
                    currentRow++;
                }

                currentRow = row;
                currentCol = col;
                currentSequence = 1;

                while (currentRow < rows - 1 && currentCol < cols - 1
                        && currentElement.equals(matrix[currentRow + 1][currentCol + 1])){

                    currentSequence++;

                    if (currentSequence > maxSequence) {
                        maxSequence = currentSequence;
                        maxRow = currentRow;
                        maxCol = currentCol;
                    }
                    currentRow++;
                    currentCol++;
                }
            }
        }

        printSequence(matrix[maxRow][maxCol], maxSequence);
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printSequence(String element, int maxSequence) {
        for (int i = 1; i < maxSequence; i++) {
            System.out.print(element + ", ");
        }
        System.out.println(element);
    }
}