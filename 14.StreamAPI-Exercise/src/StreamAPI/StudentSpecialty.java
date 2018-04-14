package StreamAPI;

public class StudentSpecialty {
    private String specialtyName;
    private String facultyNumber;

    StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public StudentSpecialty() {
    }

    String getSpecialtyName() {
        return this.specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    String getFacultyNumber() {
        return this.facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}