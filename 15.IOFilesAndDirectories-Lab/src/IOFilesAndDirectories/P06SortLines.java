package IOFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\input.txt");
        Path output = Paths.get("D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams\\output.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            Files.write(output, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}