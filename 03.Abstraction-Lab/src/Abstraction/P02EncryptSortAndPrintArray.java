package Abstraction;

import java.util.*;

public class P02EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }

        int[] encryptedNames = encryptArray(names);
        Arrays.sort(encryptedNames);
        printArray(encryptedNames);
    }

    private static int[] encryptArray(String[] names) {

        int[] encryptedArray = new int[names.length];

        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels,'a', 'e', 'i', 'o', 'u','A','E','I','O','U');

        for (int i = 0; i < names.length; i++) {

            int sum = 0;

            for (int j = 0; j < names[i].length(); j++) {
                if (vowels.contains(names[i].charAt(j))){
                    sum += names[i].charAt(j) * names[i].length();
                }else {
                    sum += names[i].charAt(j) / names[i].length();
                }
            }
            
            encryptedArray[i] = sum;
        }
        return encryptedArray;
    }

    private static void printArray(int[] encryptedNames) {
        for (int encryptedName : encryptedNames) {
            System.out.println(encryptedName);
        }
    }
}