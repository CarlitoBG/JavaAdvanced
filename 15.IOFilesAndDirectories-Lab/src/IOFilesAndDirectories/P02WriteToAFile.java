package IOFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02WriteToAFile {
    public static void main(String[] args) {
        String inputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)){
            int oneByte;
            while ((oneByte = in.read()) >= 0){
                if (!symbols.contains((char) oneByte)){
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}