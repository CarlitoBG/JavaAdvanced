package ObjectsClassesAndAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P15LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> legendaryFarming = new HashMap<>();
        legendaryFarming.put("shards", 0);
        legendaryFarming.put("fragments", 0);
        legendaryFarming.put("motes", 0);

        Map<String, String> itemName = new HashMap<>();
        itemName.put("shards", "Shadowmourne");
        itemName.put("fragments", "Valanyr");
        itemName.put("motes", "Dragonwrath");

        Map<String, Integer> junk = new TreeMap<>();

        String item = "";

        while (item.isEmpty()){
            String[] input = reader.readLine().toLowerCase().split(" ");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1];

                if (legendaryFarming.containsKey(material)){
                    legendaryFarming.put(material, legendaryFarming.get(material) + quantity);

                    if (legendaryFarming.get(material) >= 250){
                        legendaryFarming.put(material, legendaryFarming.get(material) - 250);
                        item = itemName.get(material);
                        break;
                    }
                }else {
                    if (!junk.containsKey(material)){
                        junk.put(material, 0);
                    }
                    junk.put(material, junk.get(material) + quantity);
                }
            }
        }

        System.out.println(String.format("%s obtained!", item));

        legendaryFarming.entrySet().stream().sorted((m1, m2) -> {
            int quantity = m2.getValue().compareTo(m1.getValue());

            if (quantity == 0){
                quantity = m1.getKey().compareTo(m2.getKey());
            }
            return quantity;
        })
                .forEach(material -> System.out.println(String.format("%s: %d", material.getKey(), material.getValue())));

        junk.forEach((junkItem, quantity) -> System.out.println(String.format("%s: %d", junkItem, quantity)));
    }
}