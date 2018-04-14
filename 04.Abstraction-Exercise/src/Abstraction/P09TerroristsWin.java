package Abstraction;

import java.util.Scanner;

public class P09TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] result = text.toCharArray();

        for (int charIndex = 0; charIndex < text.length(); charIndex++) {

            if (text.charAt(charIndex) == '|') {

                int bombSum = 0;
                int bombEndIndex = 0;

                for (int bombIndex = charIndex + 1; bombIndex < text.length(); bombIndex++) {
                    if (text.charAt(bombIndex) == '|') {
                        bombEndIndex = bombIndex;
                        break;
                    }
                    bombSum += text.charAt(bombIndex);
                }

                int bombPower = bombSum % 10;
                int startTextIndex = 0;
                int endTextIndex = text.length() - 1;

                if (charIndex - bombPower > startTextIndex) {
                    startTextIndex = charIndex - bombPower;
                }
                if (bombEndIndex + bombPower < endTextIndex) {
                    endTextIndex = bombEndIndex + bombPower;
                }

                for (int dotIndex = startTextIndex; dotIndex <= endTextIndex; dotIndex++) {
                    result[dotIndex] = '.';
                }

                charIndex = bombEndIndex;
            }
        }

        System.out.printf(new String(result));
    }
}