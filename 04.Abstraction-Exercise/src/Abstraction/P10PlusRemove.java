package Abstraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P10PlusRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<char[]> originalMatrix = new ArrayList<>();
        List<char[]> copyMatrix = new ArrayList<>();

        while (!line.equals("END")){

            originalMatrix.add(line.toCharArray());
            copyMatrix.add(line.toUpperCase().toCharArray());

            line = scanner.nextLine();
        }

        manipulateMatrix(originalMatrix, copyMatrix);

        printMatrix(originalMatrix);
    }

    private static void manipulateMatrix(List<char[]> originalMatrix, List<char[]> copyMatrix) {
        for (int row = 0; row < originalMatrix.size() - 2; row++) {
            for (int col = 0; col < originalMatrix.get(row).length; col++) {

                try {
                    char a = copyMatrix.get(row)[col];
                    char b = copyMatrix.get(row + 1)[col - 1];
                    char c = copyMatrix.get(row + 1)[col];
                    char d = copyMatrix.get(row + 1)[col + 1];
                    char e = copyMatrix.get(row + 2)[col];

                    if (a == b && b == c && c == d && d == e){
                        originalMatrix.get(row)[col] = '\0';
                        originalMatrix.get(row + 1)[col - 1] = '\0';
                        originalMatrix.get(row + 1)[col] = '\0';
                        originalMatrix.get(row + 1)[col + 1] = '\0';
                        originalMatrix.get(row + 2)[col] = '\0';
                    }
                }catch (IndexOutOfBoundsException e){}
            }
        }
    }

    private static void printMatrix(List<char[]> originalMatrix) {
        for (char[] row : originalMatrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\], \0]", ""));
        }
    }
}