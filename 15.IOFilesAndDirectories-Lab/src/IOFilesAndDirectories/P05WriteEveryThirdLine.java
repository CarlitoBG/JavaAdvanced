package IOFilesAndDirectories;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\output.txt";

        try (BufferedReader in  = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))){

            int counter = 1;
            String line = in.readLine();
            while (line != null){
                if (counter % 3 == 0){
                    out.println(line);
                }

                counter++;
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}