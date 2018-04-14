package IOFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08GetFolderSize {
    public static void main(String[] args) {
        String path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams";

        int size = 0;
        Deque<File> queue = new ArrayDeque<>();
        queue.offerLast(new File(path));

        while (!queue.isEmpty()) {
            File current = queue.poll();
            size += current.length();

            File[] nestedFiles = current.listFiles();
            if (nestedFiles != null) {
                for (File nestedFile : nestedFiles) {
                    queue.offerLast(nestedFile);
                }
            }
        }

        System.out.printf("Folder size: %d%n", size);
    }
}