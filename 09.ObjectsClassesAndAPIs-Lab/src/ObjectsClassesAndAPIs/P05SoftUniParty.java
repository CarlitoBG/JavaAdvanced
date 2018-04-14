package ObjectsClassesAndAPIs;

import java.util.Scanner;
import java.util.TreeSet;

public class P05SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> guestList = new TreeSet<>();

        String guest = scanner.nextLine();

        while (!guest.equals("PARTY")){
            guestList.add(guest);
            guest = scanner.nextLine();
        }

        guest = scanner.nextLine();

        while (!guest.equals("END")){
            guestList.remove(guest);
            guest = scanner.nextLine();
        }

        System.out.println(guestList.size());
        guestList.forEach(System.out::println);
    }
}