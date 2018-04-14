package IOFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10SerializeArrayList {
    public static void main(String[] args) {
        String path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\list.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            List<Double> numbers = Arrays.asList(3.14, 7.55, 6.00);
            oos.writeObject(numbers);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            Object numbers = ois.readObject();
            System.out.println(numbers);
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}