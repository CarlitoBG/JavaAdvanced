package ObjectsClassesAndAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class P16DragonArmy {
    private static final int DEFAULT_DAMAGE = 45;
    private static final int DEFAULT_HEALTH = 250;
    private static final int DEFAULT_ARMOR = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfDragons = Integer.parseInt(reader.readLine());

        Map<String, TreeMap<String, int[]>> dragonArmy = new LinkedHashMap<>();

        for (int i = 0; i < numberOfDragons; i++) {
            String[] input = reader.readLine().split("\\s+");

            String type = input[0];
            String name = input[1];
            int damage = "null".equals(input[2]) ? DEFAULT_DAMAGE : Integer.parseInt(input[2]);
            int health = "null".equals(input[3]) ? DEFAULT_HEALTH : Integer.parseInt(input[3]);
            int armor = "null".equals(input[4]) ? DEFAULT_ARMOR : Integer.parseInt(input[4]);

            if (!dragonArmy.containsKey(type)){
                dragonArmy.put(type, new TreeMap<>());
            }
            dragonArmy.get(type).put(name, new int[]{damage, health, armor});
        }

        dragonArmy.forEach((type, dragons) -> {
            double[] averageStats = new double[3];

            dragons.values().forEach(damage -> averageStats[0] += damage[0]);
            dragons.values().forEach(health -> averageStats[1] += health[1]);
            dragons.values().forEach(armor -> averageStats[2] += armor[2]);

            for (int i = 0; i < averageStats.length; i++) {
                averageStats[i] /= dragons.size();
            }

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averageStats[0], averageStats[1], averageStats[2]);

            dragons.forEach((dragon, stats) ->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon, stats[0], stats[1], stats[2]));
        });
    }
}