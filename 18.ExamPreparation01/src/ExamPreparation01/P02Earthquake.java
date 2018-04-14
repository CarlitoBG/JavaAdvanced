package ExamPreparation01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<List<Integer>> allNumbers = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            List<Integer> tempList = new ArrayList<>();
            for (String seismicity : line) {
                tempList.add(Integer.valueOf(seismicity));
            }
            allNumbers.offer(tempList);
        }

        while (!allNumbers.isEmpty()){
            List<Integer> currentNumbers = allNumbers.poll();
            int wave = currentNumbers.get(0);
            for (int i = 1; i < currentNumbers.size(); i++) {
                if (wave < currentNumbers.get(i)){
                    allNumbers.addLast(currentNumbers.subList(i, currentNumbers.size()));
                    break;
                }
            }

            output.add(wave);
        }

        System.out.println(output.size());
        System.out.println(Arrays.toString(output.toArray()).replaceAll("[\\[\\],]", ""));
    }
}