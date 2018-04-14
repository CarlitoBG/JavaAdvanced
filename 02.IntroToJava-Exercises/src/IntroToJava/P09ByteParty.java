package IntroToJava;

import java.util.Scanner;

public class P09ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbers[i] = number;
        }

        String commands = scanner.nextLine();

        while (!commands.equals("party over")){

            String[] splitCommands = commands.split("\\s+");
            int command = Integer.parseInt(splitCommands[0]);
            int position = Integer.parseInt(splitCommands[1]);

            switch (command){
                case -1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = (numbers[i] ^ (1 << position)); //flipping a bit from 1 to 0 and vice versa.
                    }
                    break;
                case 0:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = (numbers[i] & ~(1 << position)); // unset a bit - turn all bits(0 and 1) to 0.
                    }
                    break;
                case 1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = (numbers[i] | (1 << position)); // set a bit - turn all bits(0 and 1) to 1.
                    }
                    break;
            }

            commands = scanner.nextLine();
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}