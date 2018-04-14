package ObjectsClassesAndAPIs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P06SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        String currentString = "";
        Deque<String> stack = new ArrayDeque<>();
        stack.push(currentString);

        for (int i = 0; i < numberOfOperations; i++) {
            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]){
                case "1":
                    currentString += commands[1];
                    stack.push(currentString);
                    break;
                case "2":
                    int countOfElementsToErase = Integer.parseInt(commands[1]);

                    currentString = currentString.substring(0, currentString.length() - countOfElementsToErase);
                    stack.push(currentString);
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]);
                    System.out.println(currentString.charAt(index - 1));
                    break;
                case "4":
                    stack.pop();
                    currentString = stack.peek();
                    break;
            }
        }
    }
}