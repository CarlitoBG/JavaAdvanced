package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P11StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();
        List<StudentSpecialty> specialties = new ArrayList<>();

        while (true){
            String[] input = reader.readLine().split("\\s+");
            if("Students:".equals(input[0])){
                break;
            }
            String specialityName = input[0] + " " + input[1];
            String facNum = input[2];
            StudentSpecialty specialty = new StudentSpecialty(specialityName, facNum);
            specialties.add(specialty);
        }

        while (true){
            String[] input = reader.readLine().split("\\s+");
            if("END".equals(input[0])){
                break;
            }
            Student student = new Student(input[1] + " " + input[2], input[0]);
            students.add(student);
        }

        students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(student -> specialties.stream()
                        .filter((spec) -> spec.getFacultyNumber().equals(student.getFacultyNumber()))
                        .forEach(specialty -> System.out.printf("%s %s %s\n",
                                student.getName(), student.getFacultyNumber(), specialty.getSpecialtyName())));
    }
}