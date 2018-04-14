package IOFilesAndDirectories;

import java.io.*;

public class P07MergeTwoFiles {
    public static void main(String[] args) {
        String input1Path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\input.txt";
        String input2Path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\input2.txt";
        String outputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\output.txt";

        readAndWriteFile(input1Path, outputPath);
        readAndWriteFile(input2Path, outputPath);
    }

    private static void readAndWriteFile(String inputPath, String outputPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath, true))) {
            for (String line; (line = reader.readLine()) != null; ) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}