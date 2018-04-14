package ObjectsClassesAndAPIs;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double> graduationList = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String student = scanner.nextLine();
            Double[] grades = Arrays
                    .stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).toArray(Double[]::new);

            Double sum = 0.0;
            for (Double grade: grades) {
                sum += grade;
            }
            Double averageGrade = sum / grades.length;

            graduationList.put(student, averageGrade);
        }

        for (Map.Entry<String, Double> student : graduationList.entrySet()) {
            System.out.printf("%s is graduated with %s\n", student.getKey(), student.getValue());
        }
    }
}