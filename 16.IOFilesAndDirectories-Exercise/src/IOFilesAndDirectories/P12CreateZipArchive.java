package IOFilesAndDirectories;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) {
        String path1 = "D:/User/Desktop/input.txt";
        String path2 = "D:/User/Desktop/input2.txt";
        String path3 = "D:/User/Desktop/result.txt";

        try {
            String zipFile = "D:/User/Desktop/Files.zip";

            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);

            writeFilesToZip(zos, path1);
            writeFilesToZip(zos, path2);
            writeFilesToZip(zos, path3);

            zos.closeEntry();
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFilesToZip(ZipOutputStream zos, String path) throws IOException {

        FileInputStream fis = new FileInputStream(new File(path));
        ZipEntry zipEntry = new ZipEntry(path);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0){
            zos.write(bytes, 0, length);
        }
    }
}