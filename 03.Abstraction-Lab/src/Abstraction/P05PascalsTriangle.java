package Abstraction;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class P05PascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();

        BigInteger[][] pascalTriangle = new BigInteger[height][height];

        for (int currentHeight = 0; currentHeight < height; currentHeight++) {       //1
            pascalTriangle[currentHeight][0] = BigInteger.ONE;                       //1 1
            pascalTriangle[currentHeight][currentHeight] = BigInteger.ONE;           //1 2 1
                                                                                     //1 3 3 1
            if (currentHeight > 1){
                for (int col = 1; col < currentHeight; col++) {
                    BigInteger[] previousRow = pascalTriangle[currentHeight - 1];
                    BigInteger previousRowSum = previousRow[col].add(previousRow[col - 1]);
                    pascalTriangle[currentHeight][col] = previousRowSum;
                }
            }
        }

        for (BigInteger[] row : pascalTriangle) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],null]", ""));
        }
    }
}