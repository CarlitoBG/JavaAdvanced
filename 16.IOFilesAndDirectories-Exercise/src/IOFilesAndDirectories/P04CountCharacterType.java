package IOFilesAndDirectories;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class P04CountCharacterType {
    public static void main(String[] args) {
        String inputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\input.txt";
        String outputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\output.txt";

        List<Character> punctuationList = Arrays.asList('!', '?', '.', ',');
        List<Character> vowelsList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        List<Character> whiteSpacesList = Arrays.asList(' ', '\t', '\r', '\n');

        int punctuation = 0;
        int vowels = 0;
        int consonants = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){
            String line;
            while ((line = reader.readLine()) != null){
                for (char c : line.toCharArray()) {
                    if (punctuationList.contains(c)){
                        punctuation++;
                    }else if (vowelsList.contains(c)){
                        vowels++;
                    }else if (!whiteSpacesList.contains(c)){
                        consonants++;
                    }
                }
            }

            writer.printf("Vowels: %d%nConsonants: %d%nPunctuation: %d%n", vowels, consonants, punctuation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}