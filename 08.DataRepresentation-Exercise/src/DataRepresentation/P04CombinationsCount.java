package DataRepresentation;

import java.util.Scanner;

public class P04CombinationsCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        int k = Integer.parseInt(in.nextLine());
        
        System.out.println(binomialCoefficient(n, k));
    }

    private static int binomialCoefficient(int n, int k) {
        if (k < 0 || k > n){
            return 0;
        }
        if (k > n - k){
            k = n - k;
        }
        if (k == 0 || n <= 1){
            return 1;
        }
        return binomialCoefficient(n - 1, k) + binomialCoefficient(n - 1, k - 1);
    }
}