package Abstraction;

import java.util.Scanner;

public class P12ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstStarCoordinates = scanner.nextLine().split("\\s+");
        String firstStarName = firstStarCoordinates[0];
        double firstStarX = Double.parseDouble(firstStarCoordinates[1]);
        double firstStarY = Double.parseDouble(firstStarCoordinates[2]);

        String[] secondStarCoordinates = scanner.nextLine().split("\\s+");
        String secondStarName = secondStarCoordinates[0];
        double secondStarX = Double.parseDouble(secondStarCoordinates[1]);
        double secondStarY = Double.parseDouble(secondStarCoordinates[2]);

        String[] thirdStarCoordinates = scanner.nextLine().split("\\s+");
        String thirdStarName = thirdStarCoordinates[0];
        double thirdStarX = Double.parseDouble(thirdStarCoordinates[1]);
        double thirdStarY = Double.parseDouble(thirdStarCoordinates[2]);

        String[] normandyInitialCoordinates = scanner.nextLine().split("\\s+");
        double normandyX = Double.parseDouble(normandyInitialCoordinates[0]);
        double normandyY = Double.parseDouble(normandyInitialCoordinates[1]);

        int numberOfTurns = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= numberOfTurns; i++) {

            if (normandyX <= firstStarX + 1 && normandyX >= firstStarX - 1
                    && normandyY >= firstStarY - 1 && normandyY <= firstStarY + 1){
                System.out.println(firstStarName.toLowerCase());
            }else if (normandyX <= secondStarX + 1 && normandyX >= secondStarX - 1
                    && normandyY >= secondStarY - 1 && normandyY <= secondStarY + 1){
                System.out.println(secondStarName.toLowerCase());
            }else if (normandyX <= thirdStarX + 1 && normandyX >= thirdStarX - 1
                    && normandyY >= thirdStarY - 1 && normandyY <= thirdStarY + 1){
                System.out.println(thirdStarName.toLowerCase());
            }else {
                System.out.println("space");
            }

            normandyY++;
        }
    }
}