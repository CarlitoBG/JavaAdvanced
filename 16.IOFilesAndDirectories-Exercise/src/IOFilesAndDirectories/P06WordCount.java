package IOFilesAndDirectories;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) {
        String textFile = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\input2.txt";
        String wordsFile = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\words.txt";
        String result = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\result.txt";

        Map<String, Integer> wordsCount = new HashMap<>();

        fillMap(wordsFile, wordsCount);
        countWords(textFile, wordsCount);
        writeToAFile(result, wordsCount);
    }

    private static void fillMap(String wordsFile, Map<String, Integer> wordsCount) {
        try (BufferedReader reader = new BufferedReader(new FileReader(wordsFile))) {
            for (String line; (line = reader.readLine()) != null; ) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordsCount.put(word, 0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countWords(String textFile, Map<String, Integer> wordsCount) {
        try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            for (String line; (line = reader.readLine()) != null; ) {
                for (String key : wordsCount.keySet()) {
                    if (line.toLowerCase().contains(key.toLowerCase())){
                        wordsCount.put(key, wordsCount.get(key) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToAFile(String result, Map<String, Integer> wordsCount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(result))) {
            wordsCount.entrySet().stream()
                    .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                    .forEach(kvp -> writer.println(kvp.getKey() + " - " + kvp.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}