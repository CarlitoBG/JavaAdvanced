package ObjectsClassesAndAPIs;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P10CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();

        Map<Character, Integer> symbolsCount = new TreeMap<>();

        for (char symbol : text) {
            if (!symbolsCount.containsKey(symbol)){
                symbolsCount.put(symbol, 0);
            }
            symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : symbolsCount.entrySet()) {
            System.out.printf("%s: %s time/s\n", characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
        }
    }
}