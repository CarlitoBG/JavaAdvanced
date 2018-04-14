package IOFilesAndDirectories;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {
        String path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams";

        File file = new File(path);

        if (file.exists() && file.isDirectory()){
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (!f.isDirectory()){
                        System.out.printf("%s: %d%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}