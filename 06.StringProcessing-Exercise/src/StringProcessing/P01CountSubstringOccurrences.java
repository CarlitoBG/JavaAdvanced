package StringProcessing;

import java.util.Scanner;

public class P01CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        String searchString = scanner.nextLine().toLowerCase();

        int counter = 0;
        int index = text.indexOf(searchString);

        while (index != -1){
            counter++;
            index = text.indexOf(searchString, index + 1);
        }

        System.out.println(counter);
    }
}