package IOFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class P01ReadFile {
    public static void main(String[] args) {
        String path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)){
            int oneByte = fileStream.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}