package IOFilesAndDirectories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P02SumBytes {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\input.txt");
        long sum = 0;

        try (BufferedReader reader = Files.newBufferedReader(path)){

            String line = reader.readLine();

            while (line != null){
                for (char c : line.toCharArray()) {
                    sum += c;
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }
}