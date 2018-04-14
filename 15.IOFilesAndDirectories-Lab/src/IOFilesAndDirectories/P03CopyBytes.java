package IOFilesAndDirectories;

import java.io.*;

public class P03CopyBytes {
    public static void main(String[] args) {
        String inputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\input.txt";
        String outputPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\output.txt";

        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)){
            int oneByte;
            while ((oneByte = in.read()) >= 0){
                if (oneByte == 10 || oneByte == 32){
                    out.write(oneByte);
                }else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}