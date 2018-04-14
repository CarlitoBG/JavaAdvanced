package IOFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {
    public static void main(String[] args) {
        String path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\Files-and-Streams";
        File root = new File(path);

        Deque<File> folders = new ArrayDeque<>();
        folders.offer(root);

        int count = 0;
        while (!folders.isEmpty()){
            File current = folders.poll();
            System.out.println(current.getName());
            count++;

            File[] files = current.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        folders.offer(file);
                    }
                }
            }
        }

        System.out.printf("%d folders%n", count);
    }
}