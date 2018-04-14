package IntroToJava;

import java.util.Scanner;

public class P05TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer distance = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double taxiInitialTax = 0.70;
        double taxiDaytimeCost = 0.79;
        double taxiNighttimeCost = 0.90;
        double busDayNightCost = 0.09;
        double trainDayNightCost = 0.06;

        double transportPrice = 0;

        if (distance < 20){
            switch (timeOfDay){
                case "day":
                    transportPrice = taxiInitialTax + (taxiDaytimeCost * distance);
                    break;
                case "night":
                    transportPrice = taxiInitialTax + (taxiNighttimeCost * distance);
                    break;
            }
        }else if (distance >= 20 && distance < 100){
            transportPrice = busDayNightCost * distance;
        }else {
            transportPrice = trainDayNightCost * distance;
        }

        System.out.printf("%.2f", transportPrice);
    }
}