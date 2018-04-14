package IOFilesAndDirectories;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) {
        String inputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\input.txt";
        String outputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            int lineNumber = 1;
            for (String line; (line = reader.readLine()) != null;){
                writer.printf("%d. %s%n", lineNumber++, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}