package IOFilesAndDirectories;

import java.io.*;

public class P09CopyAPicture {
    public static void main(String[] args) {
        String imagePath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\picture.jpg";
        String imageCopyPath = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\picture-copy.jpg";

        try (InputStream fis = new FileInputStream(new File(imagePath));
             OutputStream fos = new FileOutputStream(new File(imageCopyPath))){

            byte[] buffer = new byte[1024];

            int length;
            while ((length = fis.read(buffer)) > 0){
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}