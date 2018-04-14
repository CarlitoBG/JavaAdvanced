package Abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParams = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = matrixParams[0];
        int cols = matrixParams[1];

        String[][] matrix = new String[rows][cols];

        applyPalindromes(matrix);

        printMatrix(matrix);
    }

    private static void applyPalindromes(String[][] matrix) {

        char firstLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                String palindrome = firstLetter + "" + (char)(firstLetter + col) + "" + firstLetter;
                matrix[row][col] = palindrome;
            }
            firstLetter++;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] palindrome : matrix) {
            System.out.println(Arrays.toString(palindrome).replaceAll("[\\[\\],]", ""));
        }
    }
}