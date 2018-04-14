package IOFilesAndDirectories;

import java.io.*;

public class P09SerializeCustomObject {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;

        String path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\save.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Cube newCube = (Cube) ois.readObject();
            System.out.println(newCube);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

class Cube implements Serializable{
    String color;
    double width;
    double height;
    double depth;
}