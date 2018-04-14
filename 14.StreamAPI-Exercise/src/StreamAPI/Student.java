package StreamAPI;

public class Student {
    private String name;
    private String facultyNumber;

    Student(String name, String facultyNumber) {
        this.name = name;
        this.facultyNumber = facultyNumber;
    }

    public Student() {
    }

    String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getFacultyNumber() {
        return this.facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}