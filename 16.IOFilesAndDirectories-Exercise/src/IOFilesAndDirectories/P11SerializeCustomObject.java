package IOFilesAndDirectories;

import java.io.*;

public class P11SerializeCustomObject {
    public static void main(String[] args) {
        String path = "D:\\User\\Documents\\Programming\\04. Java Advanced" +
                "\\08. Input-Output, Files and Directories\\Resources\\course.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            Course course = new Course("Java-Advanced", 150);
            oos.writeObject(course);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
            Course deserializedCourse = (Course) ois.readObject();
            System.out.println(deserializedCourse.getCourseName());
            System.out.println(deserializedCourse.getStudentsNumber());
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Course implements Serializable{
    private String courseName;
    private int studentsNumber;

    Course(String courseName, int studentsNumber) {
        this.courseName = courseName;
        this.studentsNumber = studentsNumber;
    }

    String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    int getStudentsNumber() {
        return this.studentsNumber;
    }

    public void setStudentsNumber(int studentsNumber) {
        this.studentsNumber = studentsNumber;
    }
}