package ObjectsClassesAndAPIs;

import java.util.HashSet;
import java.util.Scanner;

public class P04ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parkingLot = new HashSet<>();

        while (true){
            String input = scanner.nextLine();

            if (input.equals("END")){
                break;
            }else {
                String[] remainder = input.split(", ");
                if (remainder[0].equals("IN")){
                    parkingLot.add(remainder[1]);
                }else {
                    parkingLot.remove(remainder[1]);
                }
            }
        }

        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            parkingLot.forEach(System.out::println);
        }
    }
}