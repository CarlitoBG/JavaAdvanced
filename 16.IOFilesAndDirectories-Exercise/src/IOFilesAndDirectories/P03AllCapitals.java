package IOFilesAndDirectories;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {
        String inputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\input.txt";
        String outputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){
            for (String line; (line = reader.readLine()) != null;){
                writer.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}