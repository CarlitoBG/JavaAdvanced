package DataRepresentation;

import java.util.Collections;
import java.util.Scanner;

public class P05RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printFigure(number);
    }

    private static void printFigure(int number) {
        if (number == 0){
            return;
        }

        System.out.println(String.join("", Collections.nCopies(number, "*")));

        printFigure(number - 1);

        System.out.println(String.join("", Collections.nCopies(number, "#")));
    }
}