package StringProcessing;

import java.util.Scanner;

public class P08MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        String pattern = scanner.nextLine();

        while (true){
            int firstIndex = input.indexOf(pattern);
            int lastIndex = input.lastIndexOf(pattern);

            if (firstIndex == -1 || lastIndex == -1 || "".equals(pattern)){
                System.out.println("No shake.");
                break;
            }

            input = input.replace(firstIndex, firstIndex + pattern.length(), "");
            input = input.replace(lastIndex - pattern.length(), lastIndex, "");
            int index = pattern.length() / 2;
            pattern = pattern.substring(0, index) + pattern.substring(index + 1);
            System.out.println("Shaked it.");
        }

        System.out.println(input);
    }
}