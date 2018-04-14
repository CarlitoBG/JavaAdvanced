package IOFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args){
        String inputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))){
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }

                scanner.next();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}