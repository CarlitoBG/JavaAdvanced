package Abstraction;

import java.util.Scanner;

public class P11StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine().replaceAll("\\D+", ""));
        String line = scanner.nextLine();

        StringBuilder matrix = new StringBuilder();
        int maxMatrixWidth = Integer.MIN_VALUE;

        while (!line.equals("END")){

            matrix.append(line).append("\n");
            maxMatrixWidth = line.length() > maxMatrixWidth ? line.length() : maxMatrixWidth;

            line = scanner.nextLine();
        }

        String[] matrixToString = matrix.toString().split("\n");
        StringBuilder rotatedMatrix = new StringBuilder();

        switch (degrees % 360){
            case 0:
                rotatedMatrix = matrix;
                break;
            case 90:
                rotatedMatrix = RotateMatrix(maxMatrixWidth, matrixToString, rotatedMatrix);
                break;
            case 180:
                rotatedMatrix = ReverseMatrix(maxMatrixWidth, matrixToString, rotatedMatrix);
                break;
            case 270:
                rotatedMatrix = RotateMatrix(maxMatrixWidth, matrixToString, rotatedMatrix);
                rotatedMatrix.reverse();
                break;
        }

        System.out.println(rotatedMatrix);
    }

    private static StringBuilder RotateMatrix(int maxMatrixWidth, String[] matrixToString, StringBuilder rotatedMatrix) {

        for (int col = 0; col < maxMatrixWidth; col++) {
            for (int row = matrixToString.length - 1; row >= 0 ; row--) {
                try{
                    rotatedMatrix.append(matrixToString[row].charAt(col));
                }catch (IndexOutOfBoundsException e){
                    rotatedMatrix.append(" ");
                }
            }
            rotatedMatrix.append("\n");
        }
        return rotatedMatrix;
    }

    private static StringBuilder ReverseMatrix(int maxMatrixWidth, String[] matrixToString, StringBuilder rotatedMatrix) {

        for (int row = matrixToString.length - 1; row >=0; row--) {
            String str;
            if (matrixToString[row].length() < maxMatrixWidth){
                int spaces = maxMatrixWidth - matrixToString[row].length();
                str = new String(new char[spaces]).replace("\0", " ")
                        + new StringBuilder(matrixToString[row]).reverse().toString();
                rotatedMatrix.append(str).append("\n");
            }else {
                rotatedMatrix.append(new StringBuilder(matrixToString[row]).reverse().toString()).append("\n");
            }
        }
        return rotatedMatrix;
    }
}