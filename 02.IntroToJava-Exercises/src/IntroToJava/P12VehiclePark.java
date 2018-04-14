package IntroToJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P12VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> vehicles = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        String request = scanner.nextLine();

        int vehiclesSold = 0;

        while (!request.equals("End of customers!")){

            String[] requestParams = request.split("\\s+");
            String typeOfVehicle = requestParams[0].toLowerCase();
            int numberOfSeats = Integer.parseInt(requestParams[2]);

            String wantedVehicle = "" + typeOfVehicle.charAt(0) + numberOfSeats;

            if (vehicles.contains(wantedVehicle)){
                int vehiclePrice = typeOfVehicle.charAt(0) * numberOfSeats;
                System.out.printf("Yes, sold for %d$\n", vehiclePrice);
                vehicles.remove(wantedVehicle);
                vehiclesSold++;
            }else {
                System.out.println("No");
            }

            request = scanner.nextLine();
        }

        System.out.println("Vehicles left: " + vehicles.toString().replaceAll("[\\[\\]]", ""));
        System.out.println("Vehicles sold: " + vehiclesSold);
    }
}