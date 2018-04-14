package StringProcessing;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P05Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("[\\s+.,?!]+");

        Set<String> palindromes = new TreeSet<>();

        for (String word : text) {
            if (word.equals(new StringBuilder(word).reverse().toString())){
                palindromes.add(word);
            }
        }

        System.out.println(palindromes);
    }
}