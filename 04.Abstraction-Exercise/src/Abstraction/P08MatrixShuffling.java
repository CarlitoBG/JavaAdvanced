package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P08MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParams = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixParams[0];
        int cols = matrixParams[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        String[] commands = scanner.nextLine().split("\\s+");

        while (!commands[0].equals("END")) {

            if (commands.length == 5 && commands[0].equals("swap")) {

                try {
                    int row1 = Integer.parseInt(commands[1]);
                    int col1 = Integer.parseInt(commands[2]);
                    int row2 = Integer.parseInt(commands[3]);
                    int col2 = Integer.parseInt(commands[4]);

                    if (row1 < rows && col1 < cols && row2 < rows && col2 < cols) {
                        String temp = matrix[row1][col1];
                        matrix[row1][col1] = matrix[row2][col2];
                        matrix[row2][col2] = temp;

                        for (int row = 0; row < rows; row++) {
                            for (int col = 0; col < cols; col++) {
                                System.out.print(matrix[row][col] + " ");
                            }
                            System.out.println();
                        }
                    }else {
                        System.out.println("Invalid input!");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }

            commands = scanner.nextLine().split("\\s+");
        }
    }
}